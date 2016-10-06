package org.usfirst.frc.team4322.beachblitzrobot;

import org.usfirst.frc.team4322.beachblitzrobot.commands.*;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
    public OI()
    {
        PilotController.getInstance().getCollectButton().whenPressed(new Group_Collect());
        CoPilotController.getInstance().getShootButton().whenPressed(new Group_Shoot());
        CoPilotController.getInstance().getHoodDownButton().whenPressed(new Shooter_LowerHood());        
        CoPilotController.getInstance().getHoodUpButton().whenPressed(new Shooter_RaiseHood());
    }
}
