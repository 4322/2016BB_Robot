package org.usfirst.frc.team4322.beachblitzrobot.subsystems;

import org.usfirst.frc.team4322.beachblitzrobot.RobotMap;
import org.usfirst.frc.team4322.beachblitzrobot.commands.Feeder_StopFeeder;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem
{

    private CANTalon flywheelLeftTalon;
    private CANTalon flywheelRightTalon;
    private DoubleSolenoid hoodSolenoid;

    private int allowedErr = 0;

    public Shooter()
    {
        flywheelLeftTalon = new CANTalon(
                RobotMap.SHOOTER_FLYWHEEL_LEFT_TALONSRX_ID);
        flywheelLeftTalon.changeControlMode(TalonControlMode.PercentVbus);
        flywheelRightTalon = new CANTalon(
                RobotMap.SHOOTER_FLYWHEEL_RIGHT_TALONSRX_ID);
        flywheelRightTalon.changeControlMode(TalonControlMode.Follower);
        flywheelRightTalon.set(RobotMap.SHOOTER_FLYWHEEL_LEFT_TALONSRX_ID);
    }

    public void set(double rpm)
    {
        flywheelLeftTalon.set(rpm);
    }

    public void setPID(double p, double i, double d, int iZ)
    {
        flywheelLeftTalon.setPID(p, i, d, 0, iZ, 0, 0);
    }

    public void setTolerance(int allowedErr)
    {
        this.allowedErr = allowedErr;
        flywheelLeftTalon.setAllowableClosedLoopErr(allowedErr);
    }

    public boolean inTolerance()
    {
        return Math.abs(flywheelLeftTalon.getClosedLoopError()) < allowedErr;
    }

    public void raiseHood()
    {
        hoodSolenoid.set(Value.kForward);
    }

    public void lowerHood()
    {
        hoodSolenoid.set(Value.kReverse);
    }

    
    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
