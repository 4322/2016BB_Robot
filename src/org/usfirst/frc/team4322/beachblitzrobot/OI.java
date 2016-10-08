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
        PilotController.getInstance().getRaiseButton().whenPressed(new Group_StopCollector());
        PilotController.getInstance().getChevalButton().whenPressed(new Collector_Lower());
        PilotController.getInstance().getChevalButton().whenReleased(new Collector_Raise());
        PilotController.getInstance().getLowGoalButton().whenPressed(new Feeder_Eject());
        PilotController.getInstance().getLowGoalButton().whenReleased(new Feeder_StopFeeder());
        PilotController.getInstance().getForwardButton().whenPressed(new DriveBase_SetOrientation(true));
        PilotController.getInstance().getReverseButton().whenPressed(new DriveBase_SetOrientation(false));
        CoPilotController.getInstance().getShootButton().whileHeld(new Group_Shoot());
        CoPilotController.getInstance().getHoodDownButton().whenPressed(new Shooter_LowerHood());        
        CoPilotController.getInstance().getHoodUpButton().whenPressed(new Shooter_RaiseHood());
        CoPilotController.getInstance().getFireButton().whenPressed(new Feeder_LoadShooter());
        CoPilotController.getInstance().getFireButton().whenReleased(new Feeder_StopFeeder());
        CoPilotController.getInstance().getStopShooter().whenPressed(new Shooter_StopFlywheels());
        CoPilotController.getInstance().getRevButton().whenPressed(new Group_ReverseTurret());
        CoPilotController.getInstance().getRevButton().whenPressed(new Group_ReverseTurret());
        CoPilotController.getInstance().getManualShoot().whileHeld(new Shooter_RunFlywheels());
        CoPilotController.getInstance().getManualShoot().whenReleased(new Shooter_StopFlywheels());

    }
}
