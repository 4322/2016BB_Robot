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
//    	Controller.getInstance().getShoot().whileHeld(new Feeder_Run());
    	Controller.getInstance().getReady().whileHeld(new Shooter_RunFlywheels());
    	Controller.getInstance().stopFeed().whenPressed(new Feeder_StopFeeder());
    	Controller.getInstance().getHoodUp().whenPressed(new Shooter_RaiseHood());
    	Controller.getInstance().getHoodDown().whenPressed(new Shooter_LowerHood());
    	Controller.getInstance().getFeed().whenPressed(new Group_CollectDemo());
    }
}
