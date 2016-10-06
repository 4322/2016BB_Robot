package org.usfirst.frc.team4322.beachblitzrobot.subsystems;

import org.usfirst.frc.team4322.beachblitzrobot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Turret extends Subsystem
{

    private Talon turretTalon = null;

    public Turret()
    {
        turretTalon = new Talon(RobotMap.TURRET_RING_TALONSR_ID);
    }

    public void set(double speed)
    {
        turretTalon.set(speed);
    }

    public void initDefaultCommand()
    {

    }
}
