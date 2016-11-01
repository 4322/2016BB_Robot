package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Group_Eject extends CommandGroup {
    
    public  Group_Eject() {
        addSequential(new Shooter_Eject());
        addParallel(new Feeder_Eject());
        addSequential(new Command_Delay(0.2));
        addSequential(new Feeder_StopFeeder());
    }
}
