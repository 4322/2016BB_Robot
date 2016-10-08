package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoGroup_CrossCheval extends CommandGroup
{
    public AutoGroup_CrossCheval()
    {
        addSequential(new Collector_Lower());
        addSequential(new DriveBase_DriveDistance(6, .6));
        addParallel(new Collector_Raise());
        addSequential(new DriveBase_DriveDistance(60, .8));
    }
}
