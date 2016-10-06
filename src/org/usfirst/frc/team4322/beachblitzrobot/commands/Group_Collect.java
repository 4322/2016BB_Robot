package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Group_Collect extends CommandGroup
{
    public Group_Collect()
    {
        addSequential(new Collector_Lower());
        addParallel(new Collector_Collect());
        addSequential(new DriveBase_SwapForward());
    }
}
