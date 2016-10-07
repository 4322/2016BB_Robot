package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Group_LoadShooter extends CommandGroup
{
    public Group_LoadShooter()
    {
        addSequential(new Command_Delay(3));
        addSequential(new Feeder_LoadShooter());
        addSequential(new Command_Delay(.75));
    }
}
