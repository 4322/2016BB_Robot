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
    	Controller.getInstance().getShoot().whenPressed(new Group_ShootDemo());
    	Controller.getInstance().stopFeed().whenPressed(new Feeder_StopFeeder());
    	Controller.getInstance().getHoodUp().whenPressed(new Shooter_RaiseHood());
    	Controller.getInstance().getHoodDown().whenPressed(new Shooter_LowerHood());
    	Controller.getInstance().getFeed().whenPressed(new Group_Collect());
    	Controller.getInstance().getEject().whenPressed(new Group_Eject());
    	Controller.getInstance().getSpeedUp().whenPressed(new Shooter_SpeedUP());
    	Controller.getInstance().getSpeedDown().whenPressed(new Shooter_SpeedDown());
    }
}
