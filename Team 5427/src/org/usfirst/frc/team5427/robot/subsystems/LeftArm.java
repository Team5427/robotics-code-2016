package org.usfirst.frc.team5427.robot.subsystems;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.SteelTalon;
import org.usfirst.frc.team5427.robot.util.Config;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This Subsystem will be responsible for opening the Sally Port and Drawbridge.
 * Please refactor name if you think of a better name for this class:)
 * 
 * @author team5427
 */
public class LeftArm extends Subsystem {

	SpeedController motorPWM_LeftArm;

	/**
	 * DoorOpener constructor -- as parameters takes each motor to initialise.
	 * 
	 * @param motorPWM_LeftArm
	 */
	public LeftArm(SpeedController motorPWM_LeftArm) {
		this.motorPWM_LeftArm = motorPWM_LeftArm;
	}

	@Override
	protected void initDefaultCommand() {

	}

	/**
	 * Sets the speed of the left Arm motor
	 */
	public void setLeftSpeed(double speed) {
		motorPWM_LeftArm.set(speed);

	}

	

	/**
	 * Sets the speed of all motors to 0
	 */
	public void stop() {
		setLeftSpeed(0);
	}

}
