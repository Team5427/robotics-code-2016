package org.usfirst.frc.team5427.robot;

import org.usfirst.frc.team5427.robot.commands.Shoot;
import org.usfirst.frc.team5427.robot.commands.Tilt;
import org.usfirst.frc.team5427.robot.commands.intakeControl;
import org.usfirst.frc.team5427.robot.util.Config;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick joy = new Joystick(Config.JOYSTICK_PORT);
	Joystick altJoy = new Joystick(Config.ALT_JOYSTICK_PORT);
    Button toggleIntake = new JoystickButton(joy, Config.TOGGLE_INTAKE_BUTTON),
    		toTilt = new JoystickButton(joy,Config.TO_TILT_BUTTON),
    		shoot = new JoystickButton(joy,Config.SHOOTER_BUTTON),
    		button4 = new JoystickButton(joy,4),
    		button5 = new JoystickButton(joy,5),
    		button6 = new JoystickButton(joy,6),
    		button7 = new JoystickButton(joy,7),
    		button8 = new JoystickButton(joy,8);

    public OI(){ 
    	toggleIntake.toggleWhenPressed(new intakeControl());
    	toTilt.whenPressed(new Tilt());
    	shoot.toggleWhenPressed(new Shoot());
    	
    }
    
    public void toggleIntake(){
    	
    }
    
	public Joystick getJoy() {
		return joy;
	}
	

//	public Button getButton(int i){
//		if(1==i)
//			return button1;
//		else if(2==i)
//			return button2;
//		else if(3==i)
//			return button3;
//		else if(4==i)
//			return button4;
//		else if(5==i)
//			return button5;
//		else if(6==i)
//			return button6;
//		else if(7==i)
//			return button7;
//		else if(8==i)
//			return button8;
//		return null;
//	}
	
	
	public Joystick getAltJoy(){
		return altJoy;
		
	}
}
	
	
	
	
	
	
	
	//// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
	
	
	
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


