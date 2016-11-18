//This command takes care of running the intake
package org.usfirst.frc.team5427.robot.commands.subsystemControl;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;

/**
 * Tells the Intake subsystem to go on/off
 */
public class IntakeIn extends Command {

	public IntakeIn() {
		requires(Robot.intake);
		initialize();
	}

	// not used
	// Called just before this Command runs the first time
	protected void initialize() {
		// This line below is commented out because it will stop the flywheels from spinning
		// in the AutoShoot class
//		Robot.launcher.stopShoot();

	}

	// makes the intaker go until told to stop this command
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.intake.go(true);
	}

	/**
	 * Allows other classes to use execute()
	 * This is needed for the AutoShoot class
	 */
	public void forceExecute() {
		execute();
	}

	// checks if button is pressed. If it is, command continues to run. If it is
	// not, command
	// invokes end() and stops running
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return !(Robot.oi.getJoy().getRawButton(Config.INTAKE_IN_BUTTON)
				|| Robot.oi.getJoy().getRawButton(Config.INTAKE_OUT_BUTTON));
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
