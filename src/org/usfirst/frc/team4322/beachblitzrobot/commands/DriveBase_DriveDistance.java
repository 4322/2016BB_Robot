package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;
import org.usfirst.frc.team4322.beachblitzrobot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Created by nicolasmachado on 2/23/16.
 */
public class DriveBase_DriveDistance extends Command
{
    double distance;
    double power;

    public DriveBase_DriveDistance(double distance, double power)
    {
        this.distance = distance / (6 * Math.PI);
        this.power = power;
        requires(Robot.driveBase);
    }

    @Override
    protected void initialize()
    {
        Robot.driveBase.resetNavxYaw();
        Robot.driveBase.resetEncoderDistance();
    }

    @Override
    protected void execute()
    {
//      Robot.driveBase.navxDrive(RobotMap.AUTON_DRIVE_SPEED, Robot.driveBase.getNavXHeading() * RobotMap.AUTON_DRIVE_STEERING_P);
        Robot.driveBase.navxDrive(power, Robot.driveBase.getNavXYaw() * RobotMap.AUTON_DRIVE_STEERING_P);
//      Robot.driveBase.navxDrive(power, 0);
    }

    @Override
    protected boolean isFinished()
    {
        boolean finished = Math.abs(Robot.driveBase.getEncoderDistance()) >= distance;
        SmartDashboard.putNumber("DRIVE Command Target Distance: ", distance);
        SmartDashboard.putNumber("DRIVE Command Encoder Distance: ", Robot.driveBase.getEncoderDistance());
        SmartDashboard.putBoolean("DRIVE Command isFinished: ", finished);
        return finished;
    }

    @Override
    protected void end()
    {
        Robot.driveBase.navxDrive(0, 0);
        Robot.driveBase.resetEncoderDistance();
    }

    @Override
    protected void interrupted()
    {
        end();
    }
}
