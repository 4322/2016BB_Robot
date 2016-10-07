package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Feeder_Run extends Command
{
    public Feeder_Run()
    {
        requires(Robot.feeder);
        setTimeout(5);
    }

    @Override
    protected void initialize()
    {
        
    }

    @Override
    protected void execute()
    {
        Robot.feeder.set(-.5);
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
