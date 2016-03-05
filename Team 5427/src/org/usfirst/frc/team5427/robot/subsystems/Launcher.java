package org.usfirst.frc.team5427.robot.subsystems;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;

import edu.wpi.first.wpilibj.Relay;
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
	SpeedController motorPWM_Flywheel;
	
	/**
	 * Stores if the tilter is at teh bottom; if it is, the tilter won't go down further
	 */
	private boolean isTilterAtBottom;

	/**
	 * Relay which is responsible for rotating the turret mechanism to
	 * the left and right, on the horizontal axis.
	 */
	Relay motorRotateHorizontal;

	/**
	 * SpeedController which is responsible for rotating the turret up and down,
	 * on the vertical axis.
	 */
	Relay motorRotateVertical;

	/**
	 * launcher constructor -- takes motors for various parts of the launcher as
	 * parameters
	 * 
	 * @param shooter
	 * @param turner
	 * @param tilter
	 */
	public Launcher(SpeedController motorFlyWheel, Relay motorRotateHorizontal,
			Relay motorRelay_TiltTurret) {
		this.motorPWM_Flywheel = motorFlyWheel;
		this.motorRotateHorizontal = motorRotateHorizontal;
		this.motorRotateVertical = motorRelay_TiltTurret;
	}

	@Override
	protected void initDefaultCommand() {

	}

	/**
	 * sets all of the motor speeds to 0
	 */
	public void stop() {
		stopTurn();
		setTiltSpeed(0);
		setShootSpeed(0);

	}

	public void stopTurn() {
		motorRotateHorizontal.set(Relay.Value.kOff);
	}

	public void stopTilt() {
		setTiltSpeed(0);
	}

	public void stopShoot() {
		setShootSpeed(0);
	}

	/**
	 * makes the turning motor turn L/R. if direction<0, goes one way; if direction>0, 
	 * goes the other way 
	 * @param direction
	 */
	public void turn(int direction) {
		if(direction<0)
			motorRotateHorizontal.setDirection(Relay.Direction.kReverse);
		else if(direction>0)
			motorRotateHorizontal.setDirection(Relay.Direction.kForward);
		motorRotateHorizontal.set(Relay.Value.kOn);
	}

	/**
	 * sets the speed of the tilting motors to the specified speed.
	 * 
	 * @param speed
	 */
	public void tiltUp(){
		motorRotateVertical.setDirection(Relay.Direction.kForward);
		motorRotateVertical.set(Relay.Value.kOn);
	}
	public void tiltDown(){
		motorRotateVertical.setDirection(Relay.Direction.kReverse);
		motorRotateVertical.set(Relay.Value.kOn);
	}
	public void setTiltSpeed(double speed) {
		if(speed<0&&Robot.tilterLimitSwitch.get()==false) tiltUp();
		if(speed>0&&isTilterAtBottom==false) tiltDown();
		if(speed==0) stopTilt();
	}

	public void setIsTilterAtBottom(boolean t)
	{isTilterAtBottom=t;}
	
	public boolean getIsTilterAtBottom()
	{return isTilterAtBottom;}
	
	/**
	 * sets the speed of the shooting motors to the specified speed.
	 * 
	 * @param speed
	 */
	public void setShootSpeed(double speed) {
		motorPWM_Flywheel.set(speed);
	}

}
