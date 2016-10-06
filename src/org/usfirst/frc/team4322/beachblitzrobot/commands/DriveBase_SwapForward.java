package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveBase_SwapForward extends Command
{

    public DriveBase_SwapForward()
    {
        
    }
    @Override
    protected void initialize()
    {
         
    }

    @Override
    protected void execute()
    {
        Robot.driveBase.swapForward();
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
