package org.usfirst.frc.team5427.robot.commands.subsystemControl;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class UserControlledTurn extends Command {
	/**
	 * set the speed of the motor that rotates the launcher in accordance with
	 * the joystick twist axis.
	 */
	public UserControlledTurn() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.launcher);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Log.init("initialized turner");
	}

	// Called repeatedly when this Command is scheduled to run

	protected void execute() {

		Robot.launcher.turn(Robot.oi.getJoy().getTwist() * -.5);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Robot.oi.getJoy().getRawButton(Config.TO_TURRET_BUTTON) == false) {
			return true;
		}
		if ((Robot.potentiometer.get() <= Config.TURRET_POTENTIOMETER_END_ONE && Robot.oi.getJoy().getTwist() > .2)
				|| (Robot.potentiometer.get() >= Config.TURRET_POTENTIOMETER_END_TWO && Robot.oi.getJoy().getTwist() < -.2))
			return true;
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.launcher.stopTurn();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

}
