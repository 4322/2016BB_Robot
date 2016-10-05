package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Created by nicolasmachado on 2/23/16.
 * A simple class to implement a delay in a CommandGroup.
 */
public class Command_Delay extends Command
{

    long target = 0;
    long seconds = 0;
    public Command_Delay(double seconds)
    {
        this.seconds = (long) (seconds*1000);
    }
    
    @Override
    public void start()
    {
        target = System.currentTimeMillis() + seconds;
        super.start();
    }

    @Override
    protected void initialize()
    {

    }

    @Override
    protected void execute()
    {
    }

    @Override
    protected boolean isFinished()
    {
        return System.currentTimeMillis() >= target;
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
