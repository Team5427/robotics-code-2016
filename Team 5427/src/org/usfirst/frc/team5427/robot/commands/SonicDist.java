
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
	
	Ultrasonic mySonic;

	public SonicDist(Ultrasonic mySonic) {
		// Use requires() here to declare subsystem dependencies
		this.mySonic=mySonic;
	}

	

	// Called just before this Command runs the first time
	protected void initialize() {
		Log.info("initialized Sonic");
	}

	// Called repeatedly when this Command is scheduled to run

	@SuppressWarnings("all")
	protected void execute() {
		if(Math.abs(Robot.getDistance()-mySonic.getRangeInches())>500);
		else				
			Robot.distanceInInches=(mySonic.getRangeInches());
		Log.init("Dist "+Robot.getDistance());	
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
//		if(Math.abs(Robot.getDistance()-mySonic.getRangeInches())>500);
//		else				
//			Robot.distanceInInches=(mySonic.getRangeInches());
//		Log.init("Dist "+Robot.getDistance());	
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
