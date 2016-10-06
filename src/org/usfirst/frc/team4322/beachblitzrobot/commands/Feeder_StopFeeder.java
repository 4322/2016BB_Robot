package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Feeder_StopFeeder extends Command
{

    public Feeder_StopFeeder()
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
        Robot.feeder.set(0);
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
