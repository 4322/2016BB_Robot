package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4322.beachblitzrobot.commands.Shooter_RunFlywheels;

public class Group_LoadShooter extends CommandGroup
{
    public Group_LoadShooter()
    {
//        addSequential(new Command_Delay(2));
        addParallel(new Feeder_LoadShooter());
        addSequential(new Command_Delay(0.2));
        addSequential(new Feeder_StopFeeder());
//        addSequential(new Shooter_StopFlywheels());
        
    }
}