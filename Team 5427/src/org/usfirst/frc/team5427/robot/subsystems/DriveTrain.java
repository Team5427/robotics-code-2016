package org.usfirst.frc.team5427.robot.subsystems;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.SteelTalon;
import org.usfirst.frc.team5427.robot.util.Config;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This Subsystem will be responsible for managing all four SIM motors that are
 * responsible for controlling the wheels.
 *		//TODO expand on this description once more is known about the robot.
 * @author Andrew Kennedy, Bo Corman
 */
public class DriveTrain extends Subsystem {

	SpeedController frontLeft;
	SpeedController backLeft;
	SpeedController frontRight;
	SpeedController backRight;
	
	
	/**
	 * Drivetrain constructor -- as parameters takes each motor to initialise.
	 * @param frontLeft
	 * @param backLeft
	 * @param frontRight
	 * @param backRight
	 */
	public DriveTrain(SpeedController frontLeft, SpeedController backLeft, SpeedController frontRight, 
			SpeedController backRight)
	{
		this.frontLeft = frontLeft;
		this.backLeft = backLeft;
		this.frontRight = frontRight;
		this.backRight = backRight;
	}
	@Override
	protected void initDefaultCommand() {
		

	}
	/**
	 * Sets the speed of the left motors on the drive train.
	 * @param speed - the speed you want to set
	 */
	public void setLeftSpeed(double speed){
		frontLeft.set(speed);
		backLeft.set(speed);
	}
	/**
	 * Sets the speed of the right motors on the drive train.
	 * @param speed - the speed you want to set
	 */
	public void setRightSpeed(double speed){
		frontRight.set(speed);
		backRight.set(speed);
	}
	/**
	 * Sets the speed of all motors to 0
	 */
	public void stop()
	{
		setLeftSpeed(0);
		setRightSpeed(0);		
	}
	/**
	 * sets the left and right stick in occordance with the joystick inputs for a single joystick
	 * @param joyX - X axis of joystick
	 * @param joyY - Y axis of joystick
	 */
	public void driveJoystick(double joyX, double joyY)
    {
	
			double leftSpeed = (-1*joyY)+joyX;
			double rightSpeed = (-1*joyY)-joyX;
	
			rightSpeed= 0-rightSpeed;
			double max = Math.abs(leftSpeed);
	    	if(max<Math.abs(rightSpeed)) max = Math.abs(rightSpeed);
	    	if(max>1){
	    		leftSpeed = leftSpeed/max;
	    		rightSpeed = rightSpeed/max;
	    	}
	    	Robot.driveTrain.setLeftSpeed(leftSpeed);
	    	Robot.driveTrain.setRightSpeed(rightSpeed);
		
		
    }
	/**
	 * sets the left and right stick in occordance with the joystick inputs for dual joysticks
	 * @param y - Y axis of left joystick 
	 * @param y2 - Y axis of right joystick 
	 */
	public void driveDualJoystick(double y, double y2) {
		
		double leftSpeed = y;
		double rightSpeed = y2;
		Robot.driveTrain.setLeftSpeed(leftSpeed);
		Robot.driveTrain.setRightSpeed(rightSpeed);
		
	}


}
