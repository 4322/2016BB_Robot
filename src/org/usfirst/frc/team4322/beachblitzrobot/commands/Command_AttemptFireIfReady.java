package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Command_AttemptFireIfReady extends Command
{

    @Override
    protected void initialize()
    {

    }
    
    @Override
    public void start()
    {
        if(true)
        {
            Scheduler.getInstance().add(new Group_Fire());
        }
    }
    
    @Override
    protected void execute()
    {
    
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

    }

}
