package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Group_ShootDemo extends CommandGroup {
    
    public  Group_ShootDemo() {
    	addSequential(new Command_WaitForInt());
        addParallel(new Shooter_RunFlywheels());
        addSequential(new Command_Delay(0.25));
        addSequential(new Group_LoadShooter());
        addSequential(new Shooter_StopFlywheels());
    }
}
