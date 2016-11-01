package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveBase_DisableDrive extends CommandGroup {
    
    public  DriveBase_DisableDrive() {
    	addSequential(new DriveBase_SetPowerLimit(0));
    }
}
