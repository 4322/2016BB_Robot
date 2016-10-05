package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shooter_StopFlywheels extends Command
{
    public Shooter_StopFlywheels()
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
        Robot.shooter.set(0);
    }

    @Override
    protected boolean isFinished()
    {
        return true;
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
