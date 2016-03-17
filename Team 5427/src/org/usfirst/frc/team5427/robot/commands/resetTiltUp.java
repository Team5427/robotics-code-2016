package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class resetTiltUp extends Command {
	private double targetDegrees;

	/**
	 * Resets the tilter to the up and straight position
	 */

	public resetTiltUp() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.launcher);
		// requires(Robot.pot);
		targetDegrees = Config.TURRET_CENTER;
		initialize();
	}

	// Called just before this Command runs the first time
	/**
	 * sets the speed of the turn to turn the correct direction. the turn is
	 * stopped when the command ends.
	 */
	protected void initialize() {

		if (getDegrees() - targetDegrees < 0)
			Robot.launcher.turn(-1);
		else if (getDegrees() - targetDegrees > 0)
			Robot.launcher.turn(1);
		if (getDegrees() - targetDegrees == 0 || Robot.potentiometer.get() == Config.POTENTIOMETER_END_ONE
				|| Robot.potentiometer.get() == Config.POTENTIOMETER_END_TWO)
			Robot.launcher.stopTurn();
		if (getDegrees() == targetDegrees && Robot.tilterLimitSwitch.get() == false)
			Robot.launcher.tiltUp();
		Log.init("resetTiltUp done");
	}

	// Called repeatedly when this Command is scheduled to run

	protected void execute() {
		if (getDegrees() - targetDegrees < 0)
			Robot.launcher.turn(-1);
		else if (getDegrees() - targetDegrees > 0)
			Robot.launcher.turn(1);
		if (getDegrees() - targetDegrees == 0 || Robot.potentiometer.get() == Config.POTENTIOMETER_END_ONE
				|| Robot.potentiometer.get() == Config.POTENTIOMETER_END_TWO)
			Robot.launcher.stopTurn();
		if (getDegrees() == targetDegrees && Robot.tilterLimitSwitch.get() == false)
			Robot.launcher.tiltUp();
		Log.init("resetTiltUp done");
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {

		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.launcher.stopTilt();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

	protected double getDegrees() {
		return Robot.potentiometer.get();
	}

}
