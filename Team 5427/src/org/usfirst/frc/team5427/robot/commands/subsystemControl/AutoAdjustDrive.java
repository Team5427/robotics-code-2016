
package org.usfirst.frc.team5427.robot.commands.subsystemControl;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

/**
 * this class automatically moves the robot into the shooting range
 */
public class AutoAdjustDrive extends Command {

	//constants for the direction the robot needs to move
	public static final int FORWARDS = 1;
	public static final int BACKWARDS = 2;
	
	private int direction;
	private double seconds;
	
	public AutoAdjustDrive(int direction, double seconds) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
		this.direction=direction;
		this.seconds=seconds;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		super.setTimeout(seconds);
		
	}

	// Called repeatedly when this Command is scheduled to run
	@SuppressWarnings("all")
	protected void execute() {
		
		if(direction==1&&!super.isTimedOut())
		{
			Robot.driveTrain.setLeftSpeed(Config.FULL_SPEED_FORWARD);
			Robot.driveTrain.setRightSpeed(Config.FULL_SPEED_FORWARD);
		}
		else if(direction==2&&!super.isTimedOut())
		{
			Robot.driveTrain.setLeftSpeed(Config.FULL_SPEED_BACKWARD);
			Robot.driveTrain.setRightSpeed(Config.FULL_SPEED_BACKWARD);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if(super.isTimedOut())
			return true;
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
