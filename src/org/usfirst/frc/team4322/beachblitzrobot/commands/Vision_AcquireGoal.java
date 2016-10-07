package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;
import org.usfirst.frc.team4322.beachblitzrobot.RobotMap;
import org.usfirst.frc.team4322.beachblitzrobot.vision.VisionReport;

import edu.wpi.first.wpilibj.command.Command;

public class Vision_AcquireGoal extends Command
{
    private double acc,prev;
    private VisionReport lastReport;
    private int lockincount = 0;
    public Vision_AcquireGoal()
    {
        requires(Robot.turret);
        this.setTimeout(RobotMap.VISION_ACQUISITION_TIMEOUT);
    }
  
    @Override
    protected void initialize()
    {
           
    }

    @Override
    protected void execute()
    {
        VisionReport vr = Robot.vision.getVisionResults();
        if(vr == null)
        {
            if(lastReport != null)
            {
                vr = lastReport;
            }
            else
            {
                return;
            }
        }
        double err = (vr.relxpos - .5); 
        double out = RobotMap.TURRET_VISION_P*err + prev*RobotMap.TURRET_VISION_D;
        prev = err;
        if(err < RobotMap.TURRET_VISION_IZONE)
        {
            acc += err;
            out += RobotMap.TURRET_VISION_I*acc;
        }
        else
        {
            acc = 0;
        }
        Robot.turret.set(out);
        if(Math.abs(vr.relxpos-.5)<RobotMap.TURRET_VISION_ALLOWED_ERR)
        {
            lockincount++;
        }
        else
        {
            lockincount = 0;
        }
    }

    @Override
    protected boolean isFinished()
    {
        return lockincount >= RobotMap.TURRET_VISION_LOCKIN_COUNT;
    }

    @Override
    protected void end()
    {
        Robot.acquisitionWasSuccessful = !isTimedOut();
    }

    @Override
    protected void interrupted()
    {
        
    }
    
}
