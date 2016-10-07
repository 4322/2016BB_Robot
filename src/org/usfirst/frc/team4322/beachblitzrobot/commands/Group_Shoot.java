package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Group_Shoot extends CommandGroup
{
    public Group_Shoot()
    {
        addSequential(new Vision_AcquireGoal());
        addParallel(new Shooter_RunFlywheels());
        addSequential(new Command_Delay(2.5));
        addParallel(new Feeder_StopFeeder());
        addSequential(new Shooter_StopFlywheels());
    }
}
