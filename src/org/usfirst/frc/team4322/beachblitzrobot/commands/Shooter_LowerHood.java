package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shooter_LowerHood extends Command
{
    public Shooter_LowerHood()
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
        Robot.shooter.lowerHood();
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
