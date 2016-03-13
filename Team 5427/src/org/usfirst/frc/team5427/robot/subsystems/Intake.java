package org.usfirst.frc.team5427.robot.subsystems;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.SteelTalon;
import org.usfirst.frc.team5427.robot.util.Config;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This Subsystem will be responsible for managing all four SIM motors that are
 * responsible for controlling the wheels. //TODO expand on this description
 * once more is known about the robot.
 * 
 * @author team5427
 */
public class Intake extends Subsystem {

	Relay motorRelay_Intake;

	/**
	 * Intake constructor -- as parameters takes each motor to initialise.
	 * 
	 * @param motorRelay_Intake
	 */
	public Intake(Relay motorRelay_Intake) {
		this.motorRelay_Intake = motorRelay_Intake;
		motorRelay_Intake.setDirection(Relay.Direction.kForward);
	}

	@Override
	protected void initDefaultCommand() {

	}

	/**
	 * turns on the intake motor
	 */
	public void intake() {
		motorRelay_Intake.set(Relay.Value.kOn);
	}

	/**
	 * turns off the intake motor.
	 */
	public void stop() {
		motorRelay_Intake.set(Relay.Value.kOff);
	}
}
