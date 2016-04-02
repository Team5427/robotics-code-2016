//This command takes care of running the intake
package org.usfirst.frc.team5427.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

/**
 * Tells the Intake subsystem to go ON for Config.AUTO_INTAKE_TIME seconds
 */
public class AutoGetStuffIn extends Command {
	// disable shooter

	public AutoGetStuffIn() {
		// Use requires() here to declare subsystem dependencies
		// It needs the intake system
		requires(Robot.intake);
		super.setTimeout(Config.AUTO_INTAKE_TIME);
		initialize();
	}

	// not used
	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.launcher.stopShoot();

	}

	// makes the intaker go until told to stop this command
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.intake.go(true);
	}

	/**
	 * checks if timed out. If it is, command invokes end() and stops running.
	 * If it is not, command keeps running
	 */
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (isTimedOut())
			return true;
		return false;
	}

	// Called once after isFinished returns true
	// stops the intake
	public void end() {
		Robot.intake.stop();

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
