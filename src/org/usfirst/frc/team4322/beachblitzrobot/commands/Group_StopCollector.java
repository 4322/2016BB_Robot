package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Group_StopCollector extends CommandGroup
{
    public Group_StopCollector()
    {
        addSequential(new Collector_Stop());
        addParallel(new Collector_Raise());
    }
}
