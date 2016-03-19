package org.usfirst.frc.team5427.robot.commands.subsystemControl;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class ArmSpeedUp extends Command {

	

	public ArmSpeedUp() {
		requires(Robot.leftArm);
		super.setTimeout(1);
	}

	/**
	 * Called just before this Command runs the first time
	 */
	protected void initialize() {
		Log.init("initialized speedUp");
		Config.speedUp();
	}

	/**
	 * Called repeatedly when this Command is scheduled to run
	 */
	protected void execute() {

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
			return true;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.leftArm.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
