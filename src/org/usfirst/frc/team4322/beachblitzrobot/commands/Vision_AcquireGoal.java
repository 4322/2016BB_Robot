package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;
import org.usfirst.frc.team4322.beachblitzrobot.RobotMap;
import org.usfirst.frc.team4322.beachblitzrobot.vision.VisionReport;
import org.usfirst.frc.team4322.logging.RobotLogger;

import edu.wpi.first.wpilibj.command.Command;

public class Vision_AcquireGoal extends Command
{
    private double acc,prev;
    private VisionReport lastReport;
    private int lockincount = 0;
    private boolean done = false;
    public Vision_AcquireGoal()
    {
        requires(Robot.turret);
    }
  
    @Override
    protected void initialize()
    {
           
    }

    @Override
    protected void execute()
    {
    	Robot.vision.getThread().setRateLimit(50);
        double err;
        VisionReport vr = Robot.vision.getVisionResults();
        if(vr == null)
        {
            if(lastReport != null)
            {
                vr = lastReport;
                err = (vr.relxpos - .5);
            }
            else
            {
                return;
            }
        }
        else
        {
            err = (vr.relxpos - .5)*.75;
            lastReport = vr;
        }
          
        
        double out = RobotMap.TURRET_VISION_P*err + prev*RobotMap.TURRET_VISION_D;
        prev = err;
        if(Math.abs(err) < RobotMap.TURRET_VISION_IZONE)
        {
            acc += err;
            out += RobotMap.TURRET_VISION_I*acc;
        }
        else
        {
            acc = 0;
        }
        out+=Math.copySign(0.04, err);
        Robot.turret.set(out);
        if(Math.abs(vr.relxpos-.5)<RobotMap.TURRET_VISION_ALLOWED_ERR)
        {
        	if(Robot.acquisitionWasSuccessful)
                done = true;
        	Robot.acquisitionWasSuccessful = true;
        }
        else
        {
            Robot.acquisitionWasSuccessful = false;
        }
    }

    @Override
    protected boolean isFinished()
    {
        return done;
    }

    @Override
    protected void end()
    {
    	Robot.vision.getThread().setRateLimit(125);
        done = false;
        lastReport=null;
        prev=0;
    }

    @Override
    protected void interrupted()
    {
        
    }
    
}
