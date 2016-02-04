package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{
	
	SpeedController intakeLeft;
	SpeedController intakeRight;
	
	/**
	 * constructor for the intake subsystem
	 * @param left - left intake motor
	 * @param right - right intake motor
	 */
	public Intake(SpeedController left, SpeedController right){
		intakeLeft = left;
		intakeRight = right;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * sets both intake motors to 0 speed
	 */
	public void stop(){
		intakeLeft.set(0);
		intakeRight.set(0);
	}
	/**
	 * sets the speed of the intake motors to the value specified. the right motor is reversed to cause them both to spin same direction.
	 * @param speed - the speed to set the motors to (0-1)
	 */
	public void setSpeed(double speed){
		intakeLeft.set(speed);
		intakeRight.set(speed*-1);
	}
	
	

}
