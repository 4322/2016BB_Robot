package org.usfirst.frc.team4322.beachblitzrobot;

import org.usfirst.frc.team4322.input.XboxController;

import edu.wpi.first.wpilibj.buttons.Button;

public class PilotController
{
    private static PilotController _instance = null;
    private XboxController controller = null;
    
    private PilotController()
    {
        controller = new XboxController(0);
    }
    
    public static PilotController getInstance()
    {
        if(_instance == null)
        {
            _instance = new PilotController();
        }
        return _instance;
    }
    
    // Get values from left Xbox controller stick.
    public double getThrottleStick()
    {
        return controller.leftStick.getY();
    }

    // Get values from right Xbox controller stick.
    public double getSteeringStick()
    {
        return controller.rightStick.getX();
    }

    public Button getCollectButton()
    {
        return controller.lb;
    }
    
    public Button getRaiseButton()
    {
        return controller.rb;
    }
    
    public Button getChevalButton()
    {
        return controller.lt;
    }
    
    public Button getForwardButton()
    {
        return controller.a;
    }
    
    public Button getLowGoalButton()
    {
        return controller.rt;
    }
    
    public Button getReverseButton()
    {
        return controller.b;
    }
}
