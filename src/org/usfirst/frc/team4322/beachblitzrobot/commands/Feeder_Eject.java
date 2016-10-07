package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Feeder_Eject extends Command
{

    public Feeder_Eject()
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
        Robot.feeder.set(.75);
    }

    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void end()
    {
    }

    @Override
    protected void interrupted()
    {
        // TODO Auto-generated method stub

    }

}
