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
	SpeedController motorFlyWheel;

	/**
	 * SpeedController which is responsible for rotating the turret mechanism to
	 * the left and right, on the horizontal axis.
	 */
	SpeedController motorRotateHorizontal;

	/**
	 * SpeedController which is responsible for rotating the turret up and down,
	 * on the vertical axis.
	 */
	SpeedController motorRotateVertical;

	/**
	 * launcher constructor -- takes motors for various parts of the launcher as
	 * parameters
	 * 
	 * @param shooter
	 * @param turner
	 * @param tilter
	 */
	public Launcher(SpeedController motorflyWheel, SpeedController motorrotateHorizontal,
			SpeedController motor_rotateVertical) {
		this.motorFlyWheel = motorflyWheel;
		this.motorRotateHorizontal = motorrotateHorizontal;
		this.motorRotateVertical = motor_rotateVertical;
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
		motorRotateHorizontal.set(speed);
	}

	/**
	 * sets the speed of the tilting motors to the specified speed.
	 * 
	 * @param speed
	 */
	public void setTiltSpeed(double speed) {
		motorRotateVertical.set(speed);
	}

	/**
	 * sets the speed of the shooting motors to the specified speed.
	 * 
	 * @param speed
	 */
	public void setShootSpeed(double speed) {
		motorFlyWheel.set(speed);
	}

}
