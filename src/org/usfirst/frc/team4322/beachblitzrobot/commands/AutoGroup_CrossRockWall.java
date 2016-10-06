package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoGroup_CrossRockWall extends CommandGroup
{
    public AutoGroup_CrossRockWall()
    {
        addSequential(new DriveBase_DriveDistance(180, .8));
        addSequential(new Auto_AntiTortuga(this));
    }
}
