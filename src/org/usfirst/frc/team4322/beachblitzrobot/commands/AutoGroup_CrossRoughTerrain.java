package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoGroup_CrossRoughTerrain extends CommandGroup
{
    public AutoGroup_CrossRoughTerrain()
    {
        addSequential(new DriveBase_DriveDistance(132, .8));
        addSequential(new Auto_AntiTortuga(this));
    }
}
