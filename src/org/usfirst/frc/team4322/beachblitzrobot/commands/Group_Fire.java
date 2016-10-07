package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Group_Fire extends CommandGroup
{
    public Group_Fire()
    {
        addSequential(new Feeder_LoadShooter());
        addSequential(new Command_Delay(1));
        addSequential(new Feeder_StopFeeder());
        addSequential(new Shooter_StopFlywheels());
    }
}
