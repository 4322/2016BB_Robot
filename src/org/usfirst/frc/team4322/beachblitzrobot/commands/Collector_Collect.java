package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Collector_Collect extends Command
{

    public Collector_Collect()
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
        Robot.collector.collectorForward();
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
