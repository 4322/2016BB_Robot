package org.usfirst.frc.team4322.beachblitzrobot;

import org.usfirst.frc.team4322.input.XboxController;

import edu.wpi.first.wpilibj.buttons.Button;

public class CoPilotController
{
    private static CoPilotController _instance = null;
    private XboxController controller = null;
    
    private CoPilotController()
    {
        controller = new XboxController(0);
    }
    
    public static CoPilotController getInstance()
    {
        if(_instance == null)
        {
            _instance = new CoPilotController();
        }
        return _instance;
    }
    
    public Button getShootButton()
    {
        return controller.lt;
    }
    
    public Button getHoodUpButton()
    {
        return controller.rb;
    }
    
    public Button getHoodDownButton()
    {
        return controller.lb;
    }

}
