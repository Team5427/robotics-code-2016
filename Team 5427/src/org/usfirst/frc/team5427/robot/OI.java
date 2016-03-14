package org.usfirst.frc.team5427.robot;

import org.usfirst.frc.team5427.robot.commands.ScissorUp;
import org.usfirst.frc.team5427.robot.commands.SendOut;
import org.usfirst.frc.team5427.robot.commands.Drive;
import org.usfirst.frc.team5427.robot.commands.EngageLeftArm;
import org.usfirst.frc.team5427.robot.commands.EngageRightArm;
import org.usfirst.frc.team5427.robot.commands.GetStuffIn;
import org.usfirst.frc.team5427.robot.commands.NewUCTilt;
//import org.usfirst.frc.team5427.robot.commands.GetStuffIn;
import org.usfirst.frc.team5427.robot.commands.Scale;
import org.usfirst.frc.team5427.robot.commands.ScissorDown;
import org.usfirst.frc.team5427.robot.commands.Shoot;
//import org.usfirst.frc.team5427.robot.commands.SonicDist;
//import org.usfirst.frc.team5427.robot.commands.UltrasonicLog;

import org.usfirst.frc.team5427.robot.commands.UserControlledTurn;
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
			intaker = new JoystickButton(joy, Config.INTAKE_IN_BUTTON),
			outGo = new JoystickButton(joy, Config.INTAKE_OUT_BUTTON),
			toTurret = new JoystickButton(joy, Config.TO_TURRET_BUTTON),
			toTilt= new JoystickButton(joy, Config.TO_TILT_BUTTON),
			shoot = new JoystickButton(joy, Config.SHOOT_BUTTON),
			scissorDown = new JoystickButton(joy, Config.SCISSORLIFT_DOWN_BUTTON),
			scissorUp = new JoystickButton(joy, Config.SCISSORLIFT_UP_BUTTON),
			winch = new JoystickButton(joy, Config.WINCH_BUTTON),
			leftFront = new JoystickButton(joy, Config.LEFT_FRONT),
			leftBack = new JoystickButton(joy, Config.LEFT_BACK),
			rightFront = new JoystickButton(joy, Config.RIGHT_FRONT),
			rightBack = new JoystickButton(joy, Config.RIGHT_BACK);

	/**
	 * constructor for the OI class, defines the button-press events.
	 */
	public OI() {

		// DO WE NEED TO ACTIVATE start() on these??????????
		toTilt.whenPressed(new NewUCTilt());
		toTurret.whenPressed(new UserControlledTurn());
		shoot.whenPressed(new Shoot());
		intaker.whenPressed(new GetStuffIn());
		outGo.whenPressed(new SendOut());
		leftFront.whenPressed(new EngageLeftArm(true));
		leftBack.whenPressed(new EngageLeftArm(false));
		rightFront.whenPressed(new EngageRightArm(true));
		rightBack.whenPressed(new EngageRightArm(false));
		// scissorUp.whenPressed(new ScissorUp());
		// scissorDown.whenPressed(new ScissorDown());
		// scissorDown.whenPressed(new ScissorDown());
		winch.whenPressed(new Scale());
	}

	/**
	 * returns the joystick object
	 * 
	 * @return the joystick
	 */

	public Joystick getJoy() {
		return joy;
	}

	/**
	 * returns the right joystick if using 2
	 * 
	 * @return the other joystick
	 */
	public Joystick getAltJoy() {
		return altJoy;

	}
}