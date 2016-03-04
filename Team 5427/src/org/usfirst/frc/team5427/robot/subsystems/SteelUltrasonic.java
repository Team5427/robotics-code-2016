package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SteelUltrasonic extends Subsystem {
		Ultrasonic u;
		/**
		 * ultrasonic constructor -- parameter is the ultrasonic sensor.
		 * @param u
		 */
	public SteelUltrasonic(Ultrasonic u) {
		this.u = u;
	}

	@Override
	protected void initDefaultCommand() {
		
	}
	/**
	 * returns the distance in inches that the ultrasonic sensor returns.
	 * @return
	 */
	public double getUltrasonicRangeInches(){
		return u.getRangeInches();
	}
	/**
	 * TODO what does this do?
	 */
	public void ping(){
		u.ping();}
}
