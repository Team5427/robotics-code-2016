package org.usfirst.frc.team5427.robot;

import org.usfirst.frc.team5427.robot.commands.ScissorUp;
import org.usfirst.frc.team5427.robot.commands.Drive;
import org.usfirst.frc.team5427.robot.commands.Scale;
import org.usfirst.frc.team5427.robot.commands.ScissorDown;
import org.usfirst.frc.team5427.robot.commands.Shoot;
import org.usfirst.frc.team5427.robot.commands.UserControlledTilt;
import org.usfirst.frc.team5427.robot.commands.UserControlledTurn;
import org.usfirst.frc.team5427.robot.commands.intakeControl;
import org.usfirst.frc.team5427.robot.subsystems.Winch;
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
    		toTurret = new JoystickButton(joy,Config.TO_TURRET_BUTTON),
    		shoot = new JoystickButton(joy,Config.SHOOTER_BUTTON),
    		scissorDown=new JoystickButton(joy,Config.SCISSOR_DOWN_BUTTON),
    		scissorUp=new JoystickButton(joy,Config.SCISSOR_UP_BUTTON),
    		winch= new JoystickButton(joy,Config.WINCH_BUTTON);
   UserControlledTilt UCTilt;
   UserControlledTurn UCTurn;
    		
    /**
     * constructor for the OI class, defines the button-press events.
     */
    public OI(){ 
    	//toggleIntake.toggleWhenPressed(new intakeControl());
    	toTurret.cancelWhenPressed(Robot.drive);
    	//toTurret.whenPressed(UCTilt=new UserControlledTilt());
    	//toTurret.whenPressed(UCTurn=new UserControlledTurn());
    	toTurret.whenReleased(Robot.drive=new Drive());
    	//toTurret.whenReleased(UCTilt.end());
    	//toTurret.whenReleased(UCTurn.end());
    	//shoot.whenPressed(new Shoot());
    	//scissorUp.whenPressed(new ScissorUp());
    	//scissorDown.whenPressed(new ScissorDown());
    	//scissorDown.whenPressed(new ScissorDown());
    	//winch.whenPressed(new Scale());
    	
    	
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