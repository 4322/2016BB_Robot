package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Group_CollectDemo extends CommandGroup {
    
    public  Group_CollectDemo() {
       addParallel(new Feeder_Run());
       addSequential(new Command_WaitForInt());
       addSequential(new Feeder_StopFeeder());
    }
}
