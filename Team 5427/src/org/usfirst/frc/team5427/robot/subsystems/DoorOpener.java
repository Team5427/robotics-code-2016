package org.usfirst.frc.team5427.robot.subsystems;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.SteelTalon;
import org.usfirst.frc.team5427.robot.util.Config;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This Subsystem will be responsible for opening the Sally Port and Drawbridge.  Please refactor name 
 * if you think of a better name for this class:)
 * @author team5427
 */
public class DoorOpener extends Subsystem {

	SpeedController motorLeftArm;
	SpeedController motorRightArm;
	
	
	/**
	 * DoorOpener constructor -- as parameters takes each motor to initialise.
	 * @param motorLeftArm
	 * @param motorRightArm
	 */
	public DoorOpener(SpeedController motorLeftArm, SpeedController motorRightArm)
	{
		this.motorLeftArm=motorLeftArm;
		this.motorRightArm=motorRightArm;
	}
	@Override
	protected void initDefaultCommand() {
		

	}
	/**
	 * Sets the speed of the left Arm motor
	 */
	public void setLeftSpeed(double speed){
		motorLeftArm.set(speed);
		
	}
	/**
	 * Sets the speed of the right arm motor
	 * @param speed - the speed you want to set
	 */
	public void setRightSpeed(double speed){
		motorRightArm.set(speed);
	}
	/**
	 * Sets the speed of all motors to 0
	 */
	public void stop()
	{
		setLeftSpeed(0);
		setRightSpeed(0);		
	}
	


}
