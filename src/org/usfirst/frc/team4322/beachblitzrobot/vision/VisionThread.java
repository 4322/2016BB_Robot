package org.usfirst.frc.team4322.beachblitzrobot.vision;

import java.util.ArrayList;

import com.ni.vision.NIVision;
import edu.wpi.first.wpilibj.image.*;
import org.usfirst.frc.team4322.beachblitzrobot.Robot;
import org.usfirst.frc.team4322.dashboard.DashboardInputField;
import org.usfirst.frc.team4322.logging.RobotLogger;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.USBCamera;

import static com.ni.vision.NIVision.imaqDrawLineOnImage;
import static com.ni.vision.NIVision.imaqDrawShapeOnImage;


public class VisionThread extends Thread
{
    private boolean abort = false;
    private VisionReport out = null;
    private static USBCamera cam;
    private RGBImage frame;
    private BinaryImage binarizedFrame;
    private BinaryImage display;
    private long rateLimit = 50;
    private static final double idealAspect = 20 / 12;
    @DashboardInputField(field = "Red Min Value: ")
    public static int rMin = 0;
    @DashboardInputField(field = "Red Max Value: ")
    public static int rMax = 255;
    @DashboardInputField(field = "Green Min Value: ")
    public static int gMin = 245;
    @DashboardInputField(field = "Green Max Value: ")
    public static int gMax = 255;
    @DashboardInputField(field = "Blue Min Value: ")
    public static int bMin = 0;
    @DashboardInputField(field = "Blue Max Value: ")
    public static int bMax = 255;

    public VisionThread() throws NIVisionException
    {
        if(cam != null)
        {
            cam.closeCamera();
        }
        cam = new USBCamera("cam1");
        cam.openCamera();
        frame = new RGBImage();

    }

    private double ratioToScore(double ratio)
    {
        return Math.max((double) 0,
                Math.min(100 * (1 - Math.abs(1 - ratio)), (double) 100.f));
    }

    public void die()
    {
        abort = true;
    }

    public VisionReport getResult()
    {
        return out;
    }

    @Override
    public void run()
    {
        while (!abort)
        {
            try
            {
            	//Start Capture
                cam.startCapture();
                //Get Frame
                cam.getImage(frame.image);
                //Get Image size
	            int width = frame.getWidth();
	            int height  = frame.getHeight();
                //Threshold image
	            binarizedFrame = frame.thresholdRGB(rMin,rMax,gMin,gMax,bMin,bMax);
	            //Save Copy For Display
	            display = frame.thresholdRGB(rMin,rMax,gMin,gMax,bMin,bMax);
                //Count particles
                int numParticles = binarizedFrame.getNumberParticles();
                RobotLogger.getInstance().log("Particle count: %d\n",numParticles);
                ArrayList<VisionReport> objects = new ArrayList<>();
                //Get Particle measurements
	            ParticleAnalysisReport[] reports = binarizedFrame.getOrderedParticleAnalysisReports();
                //for each particle
                for (int i = 0; i < numParticles; i++)
                {
                    //populate measurements and scores
                    VisionReport vr = new VisionReport();

                    vr.area = reports[i].particleArea;
                    vr.bboxwidth = reports[i].boundingRectWidth;
                    vr.bboxheight = reports[i].boundingRectHeight;
                    vr.bboxleft = reports[i].boundingRectLeft;
                    vr.bboxtop = reports[i].boundingRectTop;
                    vr.xpos = reports[i].center_mass_x;
                    vr.ypos = reports[i].center_mass_y;
                    vr.boundingBoxArea = vr.bboxheight * vr.bboxwidth;
                    //ideally particle area should be one third of bounding box area.
                    vr.areaScore = ratioToScore((vr.area / (vr.boundingBoxArea)) * 3.0);
                    //aspect is width over height.
                    vr.aspect = (vr.bboxwidth / vr.bboxheight);
                    //particle is 20in wide 12 tall, ergo aspect ratio should be 3/5
                    vr.aspectScore = ratioToScore((vr.aspect / idealAspect) * (3.0 / 5.0));
                    //final score is average of subscores
                    vr.score = (vr.aspectScore + vr.areaScore) / 2;
                    vr.relxpos = vr.xpos / width;
                    vr.relypos = vr.ypos / height;
                    if(vr.ypos < height*.7)
                    {
                        vr.score += 10;
                    }
                    else
                    {
                        continue;
                    }
                    objects.add(vr);
                }
                //sort particles by score
                objects.sort((x, y) -> x.score > y.score ? 1 : -1);
                //log candidate particle criteria
                for (VisionReport in : objects)
                {
                    RobotLogger.getInstance().log("SCORE: %f\n", in.score);
                    RobotLogger.getInstance().log("AREA SCORE: %f ASPECT SCORE: %f\n", in.areaScore, in.aspectScore);
                    RobotLogger.getInstance().log("AREA: %f ASPECT: %f\n", in.area, in.aspect);
                    RobotLogger.getInstance().log("XPOS: %f YPOS: %f\n", in.xpos, in.ypos);
                    RobotLogger.getInstance().log("XPOS-REL: %f YPOS-REL: %f\n", in.relxpos, in.relypos);
                }
               //if we have candidates
                if (!(objects.size() == 0))
                {
                	//set best candidate as output
                    out = objects.get(0);
                    out.time = System.currentTimeMillis();
	                //draw dashboard image with candiate in bounding box with crosshairs on center of mass
                    NIVision.Rect rec = new NIVision.Rect((int) out.bboxtop + 1, (int) out.bboxleft - 1, (int) out.bboxheight + 2, (int) out.bboxwidth + 2);
                    imaqDrawShapeOnImage(display.image, display.image, rec, NIVision.DrawMode.DRAW_VALUE, NIVision.ShapeMode.SHAPE_RECT, (float) 127.0);
                    imaqDrawLineOnImage(display.image, display.image, NIVision.DrawMode.DRAW_VALUE, new NIVision.Point((int) out.xpos - 10, (int) out.ypos), new NIVision.Point((int) out.xpos - 10, (int) out.ypos + 10), 255f);
                    imaqDrawLineOnImage(display.image, display.image, NIVision.DrawMode.DRAW_VALUE, new NIVision.Point((int) out.xpos, (int) out.ypos + 10), new NIVision.Point((int) out.xpos, (int) out.ypos + 10), 255f);
                }
                //no candidate
                else
                {
                	//set null as output
                    out = null;
                }
                //display dashboard image
                CameraServer.getInstance().setImage(display.image);
                RobotLogger.getInstance().log("========END OF SCORES========\n");
                Thread.sleep(rateLimit);
            }
            catch (Exception ex)
            {
                RobotLogger.getInstance().exc("VisionThread.run()", ex); 
                cam.closeCamera();
                Robot.vision.runThread();
            }
            finally
            {
            }
        }
    }
    public void setRateLimit(long r8)
    {
    	rateLimit = r8;
    }

}