
package org.usfirst.frc.team4322.beachblitzrobot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4322.beachblitzrobot.subsystems.*;
import org.usfirst.frc.team4322.beachblitzrobot.vision.VisionThread;
import org.usfirst.frc.team4322.dashboard.MapSynchronizer;
import org.usfirst.frc.team4322.logging.RobotLogger;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{

    public static OI oi;
    public static Collector collector;
    public static DriveBase driveBase;
    public static Feeder feeder;
    public static Shooter shooter;
    public static Turret turret;
    public static Vision vision;
    public static boolean acquisitionWasSuccessful = false;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {
        RobotLogger.getInstance().update(false);
        MapSynchronizer.getInstance().link(RobotMap.class);
        MapSynchronizer.getInstance().link(VisionThread.class);
        collector = new Collector();
        driveBase = new DriveBase();
        feeder = new Feeder();
        shooter = new Shooter();
        turret = new Turret();
        vision = new Vision();
        oi = new OI();
        new Compressor().setClosedLoopControl(true);
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    public void disabledInit()
    {
        vision.stopThread();
    }

    public void disabledPeriodic()
    {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    public void autonomousInit()
    {
        vision.runThread();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit()
    {
        vision.runThread();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic()
    {
        SmartDashboard.putBoolean("Ball Detector: ",Robot.collector.ballSwitchTriggered());
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic()
    {
        LiveWindow.run();
    }
}
