package org.usfirst.frc.team4322.beachblitzrobot;

import java.io.IOException;
import java.util.jar.JarFile;

import org.usfirst.frc.team4322.dashboard.DashboardInputField;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    // Debugging info
    public static String LAST_BUILD_TIME;
    public static String COMMIT_SHORTHASH;

    /**
     * DriveBase
     */
    // Talon SRX IDs
    public static int DRIVEBASE_FRONT_LEFT_TALONSRX_ID = 10;
    public static int DRIVEBASE_FRONT_RIGHT_TALONSRX_ID = 11;
    // SLAVE Talon SRX IDs
    public static int DRIVEBASE_BACK_LEFT_TALONSRX_ID = 12;
    public static int DRIVEBASE_BACK_RIGHT_TALONSRX_ID = 13;
    public static int ENCODER_TICKS_PER_REV = 360;
    
    /**
     * Collector
     */
    public static int COLLECTOR_ARM_TALONSR_ID = 0;
    public static int COLLECTOR_ARM_DOUBLESOLENOID_LEFT_PORT = 6;
    public static int COLLECTOR_ARM_DOUBLESOLENOID_RIGHT_PORT = 7;
    public static int COLLECTOR_BALL_SWITCH_DIO_PORT = 0;
    
    /**
     * Turret
     */
    public static int TURRET_RING_TALONSR_ID = 1;
    @DashboardInputField(field="Turret P: ")
    public static double TURRET_VISION_P = 2.75;
    @DashboardInputField(field="Turret I: ")
    public static double TURRET_VISION_I = .5;
    @DashboardInputField(field="Turret D: ")
    public static double TURRET_VISION_D = 1;
    @DashboardInputField(field="Turret IZone: ")
    public static double TURRET_VISION_IZONE = .1;
    @DashboardInputField(field="Vision Lockin Count: ")
    public static int TURRET_VISION_LOCKIN_COUNT = 10;
    @DashboardInputField(field="Vision Allowed Error: ")
    public static double TURRET_VISION_ALLOWED_ERR = .15;
    public static int TURRET_LEFT_LIMIT_SWITCH = 2;
    public static int TURRET_RIGHT_LIMIT_SWITCH = 1;
    /**
     * Shooter
     */
    public static int SHOOTER_FLYWHEEL_LEFT_TALONSRX_ID = 20;
    public static int SHOOTER_FLYWHEEL_RIGHT_TALONSRX_ID = 21;
    public static int SHOOTER_HOOD_PISTON_LEFT_SOLENOID_PORT = 5;
    public static int SHOOTER_HOOD_PISTON_RIGHT_SOLENOID_PORT = 4;
    public static int SHOOTER_FLYWHEEL_RPM = 1;
    public static int SHOOTER_STABILIZATION_TIMEOUT = 1;
    public static int SHOOTER_STABLE_THRESHOLD = 5;
    
    /**
     * Feeder
     */
    public static int FEEDER_WHEEL_TALONSR_ID = 2;
    
    /**
     * Vision
     */
    public static int VISION_ACQUISITION_TIMEOUT = 2;
    
    
    /**
     * Autonomous
     */
    public static double AUTON_DRIVE_STEERING_P = 0.05;

    
    static
    {
        try
        {
            JarFile jar = new JarFile(RobotMap.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            LAST_BUILD_TIME = jar.getManifest().getMainAttributes().getValue("Build-Time");
            COMMIT_SHORTHASH = jar.getManifest().getMainAttributes().getValue("Git-Commit");
            jar.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
