package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;
import org.usfirst.frc.team4322.logging.RobotLogger;

import edu.wpi.first.wpilibj.command.Command;

public class Command_WaitForInt extends Command
{

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
        return Robot.collector.ballSwitchTriggered();
    }

    @Override
    protected void end()
    {
        RobotLogger.getInstance().log("Int found!\n");
    }

    @Override
    protected void interrupted()
    {
        // TODO Auto-generated method stub
        
    }

}
