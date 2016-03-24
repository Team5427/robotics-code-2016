package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Winch extends Subsystem {

	SpeedController motorPWM_WinchOne;
	SpeedController motorPWM_WinchTwo;

	/**
	 * Winch constructor -- parameters are the winch motors.
	 * 
	 * @param motorPWM_Winch1
	 * @param motorPWM_Winch2
	 */
	public Winch(SpeedController motorPWM_Winch1, SpeedController motorPWM_Winch2) {
		this.motorPWM_WinchOne = motorPWM_Winch1;
		this.motorPWM_WinchTwo = motorPWM_Winch2;
	}

	@Override
	protected void initDefaultCommand() {

	}

	/**
	 * sets speed of winch motors to 0
	 * 
	 */
	public void stop() {
		setSpeed(0);
	}

	/**
	 * @param speed
	 */
	public void setSpeed(double speed) {
		motorPWM_WinchOne.set(speed);
		motorPWM_WinchTwo.set(speed);
	}
}