package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Collector_Stop extends Command
{

    public Collector_Stop()
    {
        requires(Robot.collector);
    }
    @Override
    protected void initialize()
    {
         
    }

    @Override
    protected void execute()
    {
        Robot.collector.collectorStop();
    }

    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    protected void end()
    {
        // TODO Auto-generated method stub

    }

    @Override
    protected void interrupted()
    {
        // TODO Auto-generated method stub

    }

}
