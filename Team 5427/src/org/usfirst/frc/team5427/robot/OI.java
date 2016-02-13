package org.usfirst.frc.team5427.robot;

import org.usfirst.frc.team5427.robot.commands.PullUp;
import org.usfirst.frc.team5427.robot.commands.Scale;
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
    		winchDown=new JoystickButton(joy,Config.WINCH_DOWN_BUTTON),
    		winchUp=new JoystickButton(joy,Config.WINCH_UP_BUTTON);
    		
    /**
     * constructor for the OI class, defines the button-press events.
     */
    public OI(){ 
    	toggleIntake.toggleWhenPressed(new intakeControl());
    	toTilt.whenPressed(new Tilt());
    	shoot.whenPressed(new Shoot());
    	winchUp.whenPressed(new Scale());
    	winchDown.whenPressed(new PullUp());
    	
    	
    }
    /**
     * returns the joystick object
     * @return the joystick
     */
	public Joystick getJoy() {
		return joy;
	}
	


	
	/**
	 * returns the right joystick if using 2
	 * @return the other joystick
	 */
	public Joystick getAltJoy(){
		return altJoy;
		
	}
}