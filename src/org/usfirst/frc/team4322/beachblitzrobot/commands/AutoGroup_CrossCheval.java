package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoGroup_CrossCheval extends CommandGroup
{
    public AutoGroup_CrossCheval()
    {
        addSequential(new Collector_Lower());
        addSequential(new DriveBase_DriveDistance(60, .8));
        addSequential(new Collector_Raise());
    }
}
