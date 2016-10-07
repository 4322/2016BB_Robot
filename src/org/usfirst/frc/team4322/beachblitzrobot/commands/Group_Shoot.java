package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Group_Shoot extends CommandGroup
{
    public Group_Shoot()
    {
        addSequential(new Shooter_RunFlywheels());
        addSequential(new Vision_AcquireGoal());
        addSequential(new Command_Delay(1.5));
        addSequential(new Shooter_StopFlywheels());
        }
}
