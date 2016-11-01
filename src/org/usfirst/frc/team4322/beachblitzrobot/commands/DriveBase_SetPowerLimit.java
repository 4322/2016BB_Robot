package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveBase_SetPowerLimit extends Command
{

	double lim;

	public DriveBase_SetPowerLimit(double lim) 
	{
		this.lim = lim;
	}

	protected void initialize() 
	{
	}

	protected void execute() 
	{
		Robot.driveBase.setPowerLimit(lim);
	}

	protected boolean isFinished() 
	{
		return true;
	}

	protected void end()
	{
		
	}

	protected void interrupted() 
	{
		
	}
}
