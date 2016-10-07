package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveBase_SetOrientation extends Command
{
    boolean dir = false;
    public DriveBase_SetOrientation(boolean dir)
    {
        this.dir = dir;
    }
    
    @Override
    protected void initialize()
    {

    }

    @Override
    protected void execute()
    {
        if(Robot.driveBase.isReversed() == !dir)
        {
            Robot.driveBase.swapForward();
        }

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
