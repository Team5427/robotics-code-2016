package org.usfirst.frc.team5427.robot.commands.subsystemControl;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.commands.auto.AutoGetStuffIn;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class TiltForLowBar extends Command {
	boolean up = false;

	/**
	 * sets the speed of the tilting mechanism in accordance with the Y axis of
	 * the joystick.
	 */
	public TiltForLowBar() {
		// Use requires() here to declare subsystem dependencies
		System.out.println("starting a new uctilt LOW BAR");
		requires(Robot.launcher);
		initialize();
		System.out.println("made the new uctilt LOW BAR");

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		up = Robot.tilterLimitSwitch.get();
		if (up)
			super.setTimeout(Config.TILT_LOW_BAR_TIMEOUT);
		Log.init("initialized tilter");

	}

	// Called repeatedly when this Command is scheduled to run

	protected void execute() {
	//	if (Math.abs(Robot.launcher.getDegrees()) < 5.5) {
			if (up)
				Robot.launcher.tiltDown();
			else
				Robot.launcher.tiltUp();
//		} else {
//			Log.warn("Turret rotated too much to tilt");
//			end();
//		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (up && isTimedOut()) {
			Robot.launcher.setIsTilterAtBottom(true);
			return true;
		}
		if (up == false && Robot.tilterLimitSwitch.get()) {
			Robot.launcher.setIsTilterAtBottom(false);
			return true;
		}
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.launcher.stopTilt();
		if (Robot.launcher.getIsTilterAtBottom())
			new AutoGetStuffIn();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		// TODO make this end if not in autonomous

	}

}
