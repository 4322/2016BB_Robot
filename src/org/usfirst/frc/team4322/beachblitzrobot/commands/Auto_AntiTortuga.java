package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;

public class Auto_AntiTortuga extends Command
{
    
    CommandGroup crossingGroup;
    boolean commandComplete = false;
    
    public Auto_AntiTortuga(CommandGroup currentGroup )
    {
        crossingGroup = currentGroup;
    }

    @Override
    protected void initialize()
    {
        commandComplete = false;
    }

    @Override
    protected void execute()
    {
        if(!Robot.driveBase.getNavX().isMoving())
        {
            commandComplete = true;
            if(Math.abs(Robot.driveBase.getNavX().getPitch()) > 3)
            {
                Scheduler.getInstance().add(crossingGroup);
            }
        }
    }

    @Override
    protected boolean isFinished()
    {
        // This makes this command run until it's interrupted
        return commandComplete;
    }

    @Override
    protected void end()
    {
        // Stop Manual Movement in preparation for another command.
    }

    @Override
    protected void interrupted()
    {
        // Cause this command to 'end' when it's interrupted
        end();
    }

}
