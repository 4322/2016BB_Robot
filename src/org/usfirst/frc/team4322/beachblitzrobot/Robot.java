
package org.usfirst.frc.team4322.beachblitzrobot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4322.beachblitzrobot.commands.*;
import org.usfirst.frc.team4322.beachblitzrobot.subsystems.*;
import org.usfirst.frc.team4322.beachblitzrobot.vision.*;
import org.usfirst.frc.team4322.dashboard.DashboardInputField;
import org.usfirst.frc.team4322.dashboard.MapSynchronizer;
import org.usfirst.frc.team4322.logging.RobotLogger;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{

    public static OI oi;
    public static Collector collector;
    public static DriveBase driveBase;
    public static Feeder feeder;
    public static Shooter shooter;
    public static Turret turret;
    public static Vision vision;
    private static Command auto[];
    public static enum AUTO_MODES {
    	NOTHING,
    	CHEVAL,
    	MOAT,
    	RAMPARTS,
    	ROCKWALL,
    	ROUGH_TERRAIN
    };
    @DashboardInputField(field="Auto Mode:")
    public static AUTO_MODES mode = AUTO_MODES.NOTHING;
    public static boolean acquisitionWasSuccessful = false;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {
        RobotLogger.getInstance().update(false);
        MapSynchronizer.getInstance().link(RobotMap.class);
        MapSynchronizer.getInstance().link(VisionThread.class);
        MapSynchronizer.getInstance().link(RobotLogger.class);
        MapSynchronizer.getInstance().link(this.getClass());
        collector = new Collector();
        driveBase = new DriveBase();
        feeder = new Feeder();
        shooter = new Shooter();
        turret = new Turret();
        vision = new Vision();
        vision.runThread();
        oi = new OI();
        new Compressor().setClosedLoopControl(true);
        Command[] tmp ={new Command_Delay(15),new AutoGroup_CrossCheval(),new AutoGroup_CrossMoat(),new AutoGroup_CrossRamparts(),
        		new AutoGroup_CrossRockWall(), new AutoGroup_CrossRoughTerrain()};
        auto=tmp;
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    public void disabledInit()
    {
        vision.getThread().setRateLimit(125);
    }

    public void disabledPeriodic()
    {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    public void autonomousInit()
    {
        Scheduler.getInstance().add(auto[mode.ordinal()]);
        vision.getThread().setRateLimit(45);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit()
    {
        Robot.driveBase.swapForward();
        vision.getThread().setRateLimit(80);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic()
    {
        SmartDashboard.putBoolean("Ball Detector: ",Robot.collector.ballSwitchTriggered());
        SmartDashboard.putBoolean("Left Limit: ",Robot.turret.leftLimit.get());
        SmartDashboard.putBoolean("Right Limit: ",Robot.turret.rightLimit.get());
        SmartDashboard.putNumber("Encoder: ",Robot.driveBase.getEncoderDistance());
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic()
    {
        LiveWindow.run();
    }
}
 