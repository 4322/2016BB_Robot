package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Feeder_LoadShooter extends Command
{
    public Feeder_LoadShooter()
    {
        requires(Robot.feeder);
    }
    
    @Override
    protected void initialize()
    {

    }

    @Override
    protected void execute()
    {
        Robot.feeder.set(1);
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
        Robot.feeder.set(0);
    }

    @Override
    protected void interrupted()
    {
        end();
    }

}
