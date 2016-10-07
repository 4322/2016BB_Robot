package org.usfirst.frc.team4322.beachblitzrobot.subsystems;

import org.usfirst.frc.team4322.beachblitzrobot.RobotMap;
import org.usfirst.frc.team4322.beachblitzrobot.commands.Turret_ManualMove;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Turret extends Subsystem
{

    private Talon turretTalon = null;
    public DigitalInput leftLimit, rightLimit;
    public Turret()
    {
        turretTalon = new Talon(RobotMap.TURRET_RING_TALONSR_ID);
        leftLimit = new DigitalInput(RobotMap.TURRET_LEFT_LIMIT_SWITCH);
        rightLimit = new DigitalInput(RobotMap.TURRET_RIGHT_LIMIT_SWITCH);
    }

    public void set(double speed)
    {
        
        if(speed < 0 )
        {
            if(rightLimit.get())
                turretTalon.set(0);
            else
                turretTalon.set(speed);
        }
        else if(speed > 0)
        {
            if(leftLimit.get())
                turretTalon.set(0);
            else
                turretTalon.set(speed);
        }
        else
        {
            turretTalon.set(0);
        }
       
    }

    public void initDefaultCommand()
    {

    }

    @Override
    protected Command getDefaultCommand()
    {
        // TODO Auto-generated method stub
        return new Turret_ManualMove();
    }
}
