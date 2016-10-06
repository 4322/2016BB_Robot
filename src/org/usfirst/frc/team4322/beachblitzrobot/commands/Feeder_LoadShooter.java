package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Feeder_LoadShooter extends Command
{
    public Feeder_LoadShooter()
    {
        requires(Robot.feeder);
    }
    
    @Override
    protected void initialize()
    {

    }

    @Override
    protected void execute()
    {
        Robot.feeder.set(1);
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    @Override
    protected void end()
    {
    }

    @Override
    protected void interrupted()
    {
        end();
    }

}
