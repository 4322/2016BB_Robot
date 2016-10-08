
package org.usfirst.frc.team4322.beachblitzrobot.subsystems;

import org.usfirst.frc.team4322.beachblitzrobot.RobotMap;
import org.usfirst.frc.team4322.beachblitzrobot.commands.DriveBase_ArcadeDrive;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveBase extends Subsystem
{
    private CANTalon talonFrontLeft;
    private CANTalon talonBackLeft;
    private CANTalon talonFrontRight;
    private CANTalon talonBackRight;
    // Setup RobotDrive from WPILIB
    private RobotDrive robotDrive;
    private AHRS navx;
    private float resetYaw = 0;
    private boolean reversed = false;
    
    public void swapForward()
    {
        reversed = !reversed;
        robotDrive.setInvertedMotor(MotorType.kFrontLeft, reversed);
        robotDrive.setInvertedMotor(MotorType.kFrontRight, reversed);
        robotDrive.setInvertedMotor(MotorType.kRearLeft, reversed);
        robotDrive.setInvertedMotor(MotorType.kRearRight, reversed);
    }
    
    public DriveBase()
    {
        // Create instances of TalonSRX
        talonFrontLeft = new CANTalon(RobotMap.DRIVEBASE_FRONT_LEFT_TALONSRX_ID);
        talonBackLeft = new CANTalon(RobotMap.DRIVEBASE_BACK_LEFT_TALONSRX_ID);
        talonFrontRight = new CANTalon(RobotMap.DRIVEBASE_FRONT_RIGHT_TALONSRX_ID);
        talonBackRight = new CANTalon(RobotMap.DRIVEBASE_BACK_RIGHT_TALONSRX_ID);

        // Add encoder to talon config (tell the talon we are using an encoder plugged into it)
        talonFrontRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        talonFrontRight.setEncPosition(0);
        talonFrontRight.configEncoderCodesPerRev(RobotMap.ENCODER_TICKS_PER_REV);
        talonFrontLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        talonFrontLeft.setEncPosition(0);
        talonFrontLeft.configEncoderCodesPerRev(RobotMap.ENCODER_TICKS_PER_REV);
        
        // Create instance of robotDrive
        robotDrive = new RobotDrive(talonFrontLeft,talonBackLeft,talonFrontRight,talonBackRight);

        // Create NavX
        navx = new AHRS(SPI.Port.kMXP);
    }
    
    public void drive(double moveValue, double rotateValue)
    {
        drive(moveValue, rotateValue, 1);
    }
    
    public void drive(double moveValue, double rotateValue, double powerLimit)
    {
        if(reversed)
            robotDrive.arcadeDrive(moveValue * powerLimit, rotateValue * powerLimit);
        else
            robotDrive.arcadeDrive(moveValue * powerLimit, -rotateValue * powerLimit);

    }

    public void navxDrive(double moveValue, double rotateValue)
    {
        robotDrive.arcadeDrive(moveValue, -rotateValue);
    }
    
    public AHRS getNavX()
    {
        return this.navx;
    }

    public double getEncoderDistance()
    {
        return (talonFrontLeft.getPosition()) ;
    }

    public void resetNavxYaw()
    {
        resetYaw = navx.getYaw();
    }
    
    public double getNavXYaw()
    {
        return resetYaw - navx.getYaw();
    }
    
    public void resetEncoderDistance()
    {
        talonFrontLeft.setEncPosition(0);
        talonFrontRight.setEncPosition(0);
    }
    
    @Override
    protected Command getDefaultCommand()
    {
        // TODO Auto-generated method stub
        return new DriveBase_ArcadeDrive();
    }

    @Override
    protected void initDefaultCommand()
    {
           
    }
    
    public boolean isReversed()
    {
        return reversed;
    }
}
