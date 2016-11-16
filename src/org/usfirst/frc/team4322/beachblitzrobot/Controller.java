package org.usfirst.frc.team4322.beachblitzrobot;

import org.usfirst.frc.team4322.input.XboxController;

import edu.wpi.first.wpilibj.buttons.Button;


public class Controller {
	
	private static Controller _instance = null;
	private XboxController controller = null;
	
	public static Controller getInstance()
	{
		if(_instance == null)
		{
			_instance = new Controller();
			_instance.controller = new XboxController(RobotMap.MAIN);
		}
		return _instance; 
	}
	public Button getShoot() 
	{
		return controller.rt;
	}
	public Button getHoodUp()
	{
		return controller.dPad.up;
	}
	public Button getHoodDown()
	{
		return controller.dPad.down;
	}
	public Button getFeed()
	{
		return controller.a;
	}
	public Button stopFeed()
	{
		return controller.x;
	}
	public double getTurret()
	{
		return controller.getX();
	}
	public Button getEject()
	{
		return controller.y;
	}
	public Button getSpeedUp()
	{
		return controller.rb;
	}
	public Button getSpeedDown()
	{
		return controller.lb;
	}
}
