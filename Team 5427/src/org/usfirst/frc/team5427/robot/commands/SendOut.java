//This command takes care of running the intake
package org.usfirst.frc.team5427.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

/**
 * Tells the Intake subsystem to go on/off
 */
public class SendOut extends Command {

	public SendOut() {
		// Use requires() here to declare subsystem dependencies
		// It needs the intake system
		requires(Robot.intake);
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
		Robot.intake.go(false);
	}

	// checks if button is pressed. If it is, command continues to run. If it is
	// not, command
	// invokes end() and stops running
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Robot.oi.getJoy().getRawButton(Config.NEW_INTAKE_BUTTON))
			return false;
		return true;
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
