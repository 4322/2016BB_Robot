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
    }
    
    @Override
    protected void initialize()
    {

    }
    
    
    @Override
    protected void execute()
    {
        Robot.shooter.set(RobotMap.SHOOTER_FLYWHEEL_RPM);
        stablecount++;
    }

    @Override
    protected boolean isFinished()
    {
        return stablecount > 1000;
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
