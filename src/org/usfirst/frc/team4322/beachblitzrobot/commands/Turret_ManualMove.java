package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Controller;
import org.usfirst.frc.team4322.beachblitzrobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Turret_ManualMove extends Command
{

    @Override
    protected void initialize()
    {

    }

    @Override
    protected void execute()
    {
        Robot.turret.set(Controller.getInstance().getTurret());
       
    }

    @Override
    protected boolean isFinished()
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void end()
    {
        // TODO Auto-generated method stub

    }

    @Override
    protected void interrupted()
    {
        Robot.turret.set(0);

    }

}
