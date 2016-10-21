package org.usfirst.frc.team4322.beachblitzrobot.commands;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveBase_ArcadeDrive extends Command
{

    public DriveBase_ArcadeDrive()
    {
        // Make ArcadeDrive require the DriveBase
        // Robot.driveBase refers to the instance of DriveBase created in Robot.java during init.
        requires(Robot.driveBase);
    }

    @Override
    protected void initialize()
    {
        // You can use this if you need to reset a Gyro, wait for movement to stop, or something of that nature.
    }

    @Override
    protected void execute()
    {
        // This will run ArcadeDrive in DriveBase
        // This code provide the values for the arguments we require while setting up ArcadeDrive, including our Power
        // Limit
//        Robot.driveBase.drive(PilotController.getInstance().getThrottleStick(), PilotController.getInstance()
//                .getSteeringStick());
    }

    @Override
    protected boolean isFinished()
    {
        // This makes this command run until it's interrupted
        return false;
    }

    @Override
    protected void end()
    {
        // Set ArcadeDrive values to '0' in order to prepare for the next command/operation.
        // If these were not set to '0', ArcadeDrive would continue running with the last values it received from the
        // controller.
        Robot.driveBase.drive(0, 0);
    }

    @Override
    protected void interrupted()
    {
        // Cause this command to 'end' when it's interrupted
        end();
    }

}