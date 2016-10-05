package org.usfirst.frc.team4322.beachblitzrobot.subsystems;

import org.usfirst.frc.team4322.beachblitzrobot.Robot;
import org.usfirst.frc.team4322.beachblitzrobot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.InterruptHandlerFunction;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {
    
    private DoubleSolenoid collectorPistons;
    private Talon collectorTalon;
    private DigitalInput ballSwitch;
            
    private static class BallInterruptHandler extends InterruptHandlerFunction<Object>
    {

        @Override
        public void interruptFired(int interruptAssertedMask, Object param)
        {
            Robot.collector.collectorTalon.set(0);
            Robot.collector.ballSwitch.disableInterrupts();
            Robot.driveBase.swapForward();
            Robot.collector.retractArm();
        }
        
    }
    public Collector()
    {
        collectorPistons = new DoubleSolenoid(RobotMap.COLLECTOR_ARM_DOUBLESOLENOID_LEFT_PORT,
                                              RobotMap.COLLECTOR_ARM_DOUBLESOLENOID_RIGHT_PORT);
        collectorTalon = new Talon(RobotMap.COLLECTOR_ARM_TALONSR_ID);
        ballSwitch = new DigitalInput(RobotMap.COLLECTOR_BALL_SWITCH_DIO_PORT);
        ballSwitch.requestInterrupts(new BallInterruptHandler());
        
    }

    public boolean ballSwitchTriggered()
    {
        return ballSwitch.get();
    }
    
    public void extendArm()
    {
        collectorPistons.set(Value.kForward);
        Robot.collector.ballSwitch.enableInterrupts();
    }
    
    public void retractArm()
    {
        collectorPistons.set(Value.kReverse);
    }
    
    public void collectorStop()
    {
        collectorTalon.set(0);
    }
    
    public void collectorForward()
    {
        collectorTalon.set(1);
    }
    
    public void collectorBackward()
    {
        collectorTalon.set(-1);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

