package org.usfirst.frc.team4322.beachblitzrobot.subsystems;

import org.usfirst.frc.team4322.beachblitzrobot.RobotMap;
import org.usfirst.frc.team4322.beachblitzrobot.commands.Feeder_StopFeeder;
import org.usfirst.frc.team4322.beachblitzrobot.commands.Shooter_RunFlywheels;
import org.usfirst.frc.team4322.beachblitzrobot.commands.Shooter_StopFlywheels;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
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
    private DigitalInput flywheelSensor;
    private Counter flywheelRPMCount;

    private int allowedErr = 0;

    public Shooter()
    {
        flywheelLeftTalon = new CANTalon(
                RobotMap.SHOOTER_FLYWHEEL_LEFT_TALONSRX_ID);
        flywheelLeftTalon.changeControlMode(TalonControlMode.PercentVbus);
        flywheelLeftTalon.enableBrakeMode(false);;
        flywheelRightTalon = new CANTalon(
                RobotMap.SHOOTER_FLYWHEEL_RIGHT_TALONSRX_ID);
        flywheelRightTalon.changeControlMode(TalonControlMode.Follower);
        flywheelRightTalon.enableBrakeMode(false);
        flywheelRightTalon.set(RobotMap.SHOOTER_FLYWHEEL_LEFT_TALONSRX_ID);
        flywheelSensor = new DigitalInput(RobotMap.SHOOTER_FLYWHEEL_SENSOR);
        hoodSolenoid = new DoubleSolenoid(RobotMap.SHOOTER_HOOD_PISTON_LEFT_SOLENOID_PORT,RobotMap.SHOOTER_HOOD_PISTON_RIGHT_SOLENOID_PORT);
        hoodSolenoid.set(Value.kReverse);
        flywheelRPMCount = new Counter(RobotMap.SHOOTER_FLYWHEEL_SENSOR);
        flywheelRPMCount.setSemiPeriodMode(true);
    }

    public void set(double rpm)
    {
        flywheelLeftTalon.set(rpm);
    }
    public boolean getInput ()
    {
    	return flywheelSensor.get();
    }
    public double getPulse()
    {
    	return flywheelRPMCount.getPeriod();
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
        hoodSolenoid.set(Value.kReverse);
    }

    public void lowerHood()
    {
        hoodSolenoid.set(Value.kForward);
    }

    
    @Override
    protected Command getDefaultCommand()
    {
        // TODO Auto-generated method stub
        return new Shooter_StopFlywheels();
    }

    public void initDefaultCommand()
    {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
