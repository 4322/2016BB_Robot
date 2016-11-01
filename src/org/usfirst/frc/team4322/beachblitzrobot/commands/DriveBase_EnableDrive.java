package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveBase_EnableDrive extends CommandGroup {
    
    public  DriveBase_EnableDrive() {
        addSequential(new DriveBase_SetPowerLimit(1.0));
    }
}
