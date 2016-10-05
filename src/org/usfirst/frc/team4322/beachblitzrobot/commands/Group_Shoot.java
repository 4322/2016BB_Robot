package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Group_Shoot extends CommandGroup
{
    public Group_Shoot()
    {
        addParallel(new Shooter_RunFlywheels());
        addSequential(new Vision_AcquireGoal());
        addSequential(new Command_AttemptFireIfReady());
    }
}
