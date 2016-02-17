package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SteelUltrasonic extends Subsystem {
		Ultrasonic u;
	public SteelUltrasonic(Ultrasonic u) {
		this.u = u;
	}

	@Override
	protected void initDefaultCommand() {
		
	}
	public double getUltrasonicRangeInches(){
		return u.getRangeInches();
	}
}
