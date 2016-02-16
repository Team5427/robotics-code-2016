package org.usfirst.frc.team5427.robot.subsystems;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * the launcher subsystem is used for controlling the mechanism that launches
 * boulders, and involves 3 different parts, the shooting motors, turning
 * motors, and angling/tilting motors.
 * 
 * @author team5427
 *
 */
public class Launcher extends Subsystem {

	/**
	 * SpeedController which is responsible for the flywheel that launches the
	 * boulder out of the robot.
	 */
	SpeedController motor_flyWheel;

	/**
	 * SpeedController which is responsible for rotating the turret mechanism to
	 * the left and right, on the horizontal axis.
	 */
	SpeedController motor_rotateHorizontal;

	/**
	 * SpeedController which is responsible for rotating the turret up and down,
	 * on the vertical axis.
	 */
	SpeedController motor_rotateVertical;

	/**
	 * launcher constructor -- takes motors for various parts of the launcher as
	 * parameters
	 * 
	 * @param shooter
	 * @param turner
	 * @param tilter
	 */
	public Launcher(SpeedController motor_flyWheel, SpeedController motor_rotateHorizontal,
			SpeedController motor_rotateVertical) {
		this.motor_flyWheel = motor_flyWheel;
		this.motor_rotateHorizontal = motor_rotateHorizontal;
		this.motor_rotateVertical = motor_rotateVertical;
	}

	@Override
	protected void initDefaultCommand() {

	}

	/**
	 * sets all of the motor speeds to 0
	 */
	public void stop() {
		setTurnSpeed(0);
		setTiltSpeed(0);
		setShootSpeed(0);

	}

	public void stopTurn() {
		setTurnSpeed(0);
	}

	public void stopTilt() {
		setTiltSpeed(0);
	}

	public void stopShoot() {
		setShootSpeed(0);
	}

	/**
	 * sets the speed of the turning motors to the specified speed.
	 * 
	 * @param speed
	 */
	public void setTurnSpeed(double speed) {
		motor_rotateHorizontal.set(speed);
	}

	/**
	 * sets the speed of the tilting motors to the specified speed.
	 * 
	 * @param speed
	 */
	public void setTiltSpeed(double speed) {
		motor_rotateVertical.set(speed);
	}

	/**
	 * sets the speed of the shooting motors to the specified speed.
	 * 
	 * @param speed
	 */
	public void setShootSpeed(double speed) {
		motor_flyWheel.set(speed);
	}

}
