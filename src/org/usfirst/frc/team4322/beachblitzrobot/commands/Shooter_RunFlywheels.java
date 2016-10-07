package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;
import org.usfirst.frc.team4322.beachblitzrobot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Shooter_RunFlywheels extends Command
{
    private int stablecount;
    public Shooter_RunFlywheels()
    {
        requires(Robot.shooter);
        setTimeout(RobotMap.SHOOTER_STABILIZATION_TIMEOUT);
    }
    
    @Override
    protected void initialize()
    {

    }
    
    public void start()
    {
        Robot.shooter.set(RobotMap.SHOOTER_FLYWHEEL_RPM);
    }
    
    @Override
    protected void execute()
    {
        stablecount++;
    }

    @Override
    protected boolean isFinished()
    {
        return stablecount > RobotMap.SHOOTER_STABLE_THRESHOLD;
    }

    @Override
    protected void end()
    {
        
    }
    
    @Override
    protected void interrupted()
    {
        
    }

}
