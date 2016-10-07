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
        this.seconds = Math.round(seconds*1000);
        this.seconds /=20;
    }
    

    @Override
    protected void initialize()
    {

    }

    @Override
    protected void execute()
    {
        target+=1;
    }

    @Override
    protected boolean isFinished()
    {
        return target >= seconds;
    }

    @Override
    protected void end()
    {
        target = 0;
    }

    @Override
    protected void interrupted()
    {
        end();
    }
}
