package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Group_Collect extends CommandGroup
{
    public Group_Collect()
    {
        addSequential(new Collector_Lower());
        addParallel(new Feeder_Run());
        addParallel(new Collector_Collect());
        addSequential(new Command_WaitForInt());
        addSequential(new Feeder_StopFeeder());
        addSequential(new Collector_Stop());
        addSequential(new Collector_Raise());
    }
}
