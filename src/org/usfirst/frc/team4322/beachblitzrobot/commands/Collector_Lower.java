package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Collector_Lower extends Command
{

    public Collector_Lower()
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
        Robot.collector.extendArm();
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

    }

    @Override
    protected void interrupted()
    {
        // TODO Auto-generated method stub

    }

}
