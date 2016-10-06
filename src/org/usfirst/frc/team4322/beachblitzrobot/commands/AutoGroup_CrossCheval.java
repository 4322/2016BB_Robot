package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoGroup_CrossCheval extends CommandGroup
{
    public AutoGroup_CrossCheval()
    {
        addParallel(new Collector_Collect());
        addSequential(new Collector_Lower());
        addParallel(new Collector_Stop());
        addSequential(new DriveBase_DriveDistance(6, .6));
        addSequential(new DriveBase_DriveDistance(60, .8));
    }
}
