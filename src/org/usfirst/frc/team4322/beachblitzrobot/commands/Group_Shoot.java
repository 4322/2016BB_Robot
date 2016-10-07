package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Group_Shoot extends CommandGroup
{
    public Group_Shoot()
    {
        addSequential(new Shooter_RunFlywheels());
        addSequential(new Vision_AcquireGoal());
        addSequential(new Command_Delay(1.0));
        addSequential(new Feeder_LoadShooter());
        addSequential(new Command_Delay(1.0));
        addParallel(new Feeder_StopFeeder());
        addSequential(new Shooter_StopFlywheels());
        }
}
