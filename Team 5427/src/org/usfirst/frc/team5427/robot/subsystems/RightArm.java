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
public class RightArm extends Subsystem {

	SpeedController motorPWM_RightArm;

	/**
	 * DoorOpener constructor -- as parameters takes each motor to initialise.
	 * 
	 * @param motorPWM_RightArm
	 */
	public RightArm(SpeedController motorPWM_RightArm) {
		this.motorPWM_RightArm = motorPWM_RightArm;
	}

	@Override
	protected void initDefaultCommand() {

	}



	/**
	 * Sets the speed of the right arm motor
	 * 
	 * @param speed
	 *            - the speed you want to set
	 */
	public void setRightSpeed(double speed) {
		// AAA
		motorPWM_RightArm.set(-speed);
	}

	/**
	 * Sets the speed of all motors to 0
	 */
	public void stop() {
		setRightSpeed(0);
	}

}
