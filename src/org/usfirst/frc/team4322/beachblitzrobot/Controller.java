package org.usfirst.frc.team4322.beachblitzrobot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Controller extends Joystick {
	
	private static Controller _instance;
	private Controller()
	{
		super(0);
	}
	
	public static Controller getInstance()
	{
		if(_instance == null)
		{
			_instance = new Controller();
		}
		return _instance; 
	}
	public Button getShoot() 
	{
		return new JoystickButton(this,1);
	}
	public Button getReady()
	{
		return new JoystickButton(this,2);
	}
	public Button getHoodUp()
	{
		return new JoystickButton(this,3);
	}
	public Button getHoodDown()
	{
		return new JoystickButton(this,2);
	}
	public Button getFeed()
	{
		return new JoystickButton(this,4);
	}
	public Button stopFeed()
	{
		return new JoystickButton(this,6);
	}
	public double getTurret()
	{
		return this.getX();
	}
	public Button getEject()
	{
		return new JoystickButton(this,7);
	}
}
