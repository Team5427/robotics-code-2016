package org.usfirst.frc.team5427.robot;

import org.usfirst.frc.team5427.robot.commands.auto.AutoShoot;
import org.usfirst.frc.team5427.robot.commands.auto.AutoTurn;
import org.usfirst.frc.team5427.robot.commands.auto.autonomous.AutonomousSelector;
import org.usfirst.frc.team5427.robot.commands.auto.autonomous.Lowbar;
import org.usfirst.frc.team5427.robot.commands.auto.autonomous.Moat;
import org.usfirst.frc.team5427.robot.commands.auto.autonomous.Ramparts;
import org.usfirst.frc.team5427.robot.commands.auto.autonomous.Rockwall;
import org.usfirst.frc.team5427.robot.commands.auto.autonomous.RoughTerrain;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.ArmSpeedDown;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.ArmSpeedUp;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.Drive;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.EngageLeftArm;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.EngageRightArm;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.IntakeIn;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.IntakeOut;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.RotateTurret;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.Scale;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.ScissorDown;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.ScissorUp;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.Shoot;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.TiltForCollecting;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.TiltForLowBar;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.UserControlledWinch;
import org.usfirst.frc.team5427.robot.network.Client;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.UserControlledTurn;
import org.usfirst.frc.team5427.robot.subsystems.Winch;
import org.usfirst.frc.team5427.robot.util.AutonomousMode;
import org.usfirst.frc.team5427.robot.util.Config;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick joy = new Joystick(Config.JOYSTICK_PORT);
	Joystick altJoy = new Joystick(Config.ALT_JOYSTICK_PORT);
	Button intaker = new JoystickButton(joy, Config.INTAKE_IN_BUTTON),
			outGo = new JoystickButton(joy, Config.INTAKE_OUT_BUTTON),
			tiltCollect = new JoystickButton(joy, Config.TILT_COLLECT_BUTTON),
			tiltLowBar = new JoystickButton(joy, Config.TILT_LOW_BAR_BUTTON),
			shoot = new JoystickButton(joy, Config.SHOOT_BUTTON),
			scissorDown = new JoystickButton(joy, Config.SCISSORLIFT_DOWN_BUTTON),
			scissorUp = new JoystickButton(joy, Config.SCISSORLIFT_UP_BUTTON),
			winch = new JoystickButton(joy, Config.WINCH_BUTTON),
			leftFront = new JoystickButton(joy, Config.LEFT_FRONT_ARM_BUTTON),
			leftBack = new JoystickButton(joy, Config.LEFT_BACK_ARM_BUTTON),
			rightFront = new JoystickButton(joy, Config.RIGHT_FRONT_ARM_BUTTON),
			rightBack = new JoystickButton(joy, Config.RIGHT_BACK_ARM_BUTTON);

	/**
	 * constructor for the OI class, defines the button-press events.
	 */
	public OI() {

		tiltCollect.whenPressed(new TiltForCollecting());
		tiltLowBar.whenPressed(new TiltForLowBar());
		shoot.whenPressed(new Shoot());
		// shoot.whenPressed(new AutoShoot());
		intaker.whenPressed(new IntakeIn());
		outGo.whenPressed(new IntakeOut());
		leftFront.whenPressed(new EngageLeftArm(true));
		leftBack.whenPressed(new EngageLeftArm(false));
		rightFront.whenPressed(new EngageRightArm(true));
		rightBack.whenPressed(new EngageRightArm(false));
		// scissorUp.whenPressed(new ScissorUp());
		scissorUp.whenPressed(new RotateTurret(0));
		// scissorDown.whenPressed(new
		// RotateTurret(Client.lastReceivedGoal.getHorizontalAngle()));
		// scissorDown.whenPressed(new ScissorDown());
		winch.whenPressed(new UserControlledTurn());// change to "new Winch()"
													// after testing and making
													// sure the GRIP works
		// winch.whenPressed(new UserControlledWinch());
		// Moat, rough terrain, rockwall, ramparts, lowbar
		SmartDashboard.putData("Autonomous: Moat            ", new AutonomousSelector(AutonomousMode.Moat));
		SmartDashboard.putData("Autonomous: Rough Terrain   ", new AutonomousSelector(AutonomousMode.RoughTerrain));
		SmartDashboard.putData("Autonomous: Rockwall        ", new AutonomousSelector(AutonomousMode.Rockwall));
		SmartDashboard.putData("Autonomous: Ramparts        ", new AutonomousSelector(AutonomousMode.Ramparts));
		SmartDashboard.putData("Autonomous: Lowbar          ", new AutonomousSelector(AutonomousMode.Lowbar));

		SmartDashboard.putData("ArmSpeedDown", new ArmSpeedDown());
		SmartDashboard.putData("ArmSpeedUp", new ArmSpeedUp());

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