package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Group_ReverseTurret extends CommandGroup
{
    public Group_ReverseTurret()
    {
        addSequential(new Shooter_Eject());
        addSequential(new Feeder_Eject());
    }
}
