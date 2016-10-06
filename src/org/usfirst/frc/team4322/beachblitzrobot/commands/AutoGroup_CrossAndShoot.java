package org.usfirst.frc.team4322.beachblitzrobot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoGroup_CrossAndShoot extends CommandGroup
{
    public AutoGroup_CrossAndShoot(CommandGroup cross)
    {
        addSequential(cross);
        addSequential(new Vision_AcquireGoal());
        addSequential(new Group_Shoot());
    }
}
