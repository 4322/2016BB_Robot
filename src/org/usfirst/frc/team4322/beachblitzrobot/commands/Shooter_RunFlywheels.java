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
        setTimeout(1.5);
        requires(Robot.feeder);
    }
    
    @Override
    protected void initialize()
    {

    }
    
    
    @Override
    protected void execute()
    {
        Robot.shooter.set(RobotMap.SHOOTER_FLYWHEEL_RPM);
        Robot.feeder.set(-1);
    }

    @Override
    protected boolean isFinished()
    {
        return isTimedOut();
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
