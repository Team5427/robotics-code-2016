
package org.usfirst.frc.team5427.robot.commands;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

/**
 * this class constantly inputs the Joystick axis into the driveTrain file, causing the robot to move.
 */
public class SonicDist extends Command {
	
	//Ultrasonic mySonic;

	public SonicDist() {
		// Use requires() here to declare subsystem dependencies
		//this.mySonic=mySonic;
	}

	

	// Called just before this Command runs the first time
	protected void initialize() {
		Log.init("initialized Sonic");
	}

	// Called repeatedly when this Command is scheduled to run

	@SuppressWarnings("all")
	protected void execute() {
		if(Math.abs(Robot.getDistance()-Robot.mySonic.getRangeInches())>500);
		else				
			Robot.distanceInInches=(Robot.mySonic.getRangeInches());
		Log.debug("Dist1 "+Robot.getDistance());	
		if(Math.abs(Robot.getDistance()-Robot.mySonic.getRangeInches())>50);
		else				
			Robot.distanceInInches=(Robot.mySonic.getRangeInches());
		Log.debug("Dist2 "+Robot.getDistance());	
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if(Robot.oi.getJoy().getRawButton(Config.ULTRASONIC_BUTTON))
				return false;
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
		this.cancel();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
