package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class NewUCTilt extends Command {
	boolean up;
	/**
	 * sets the speed of the tilting mechanism in accordance with the Y axis of
	 * the joystick.
	 */
	public NewUCTilt() {
		// Use requires() here to declare subsystem dependencies
		System.out.println("starting a new uctilt");
		requires(Robot.launcher);
		initialize();
		System.out.println("made the new uctilt");
		
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		up=Robot.tilterLimitSwitch.get();
		if(up)
			super.setTimeout(Config.TILT_TIMEOUT);
		Log.init("initialized tilter");
		
	}

	// Called repeatedly when this Command is scheduled to run

	protected void execute() {
		// sets the speed of the turning motor
		if(up)
			Robot.launcher.tiltDown();
		else
			Robot.launcher.tiltUp();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if(up&&isTimedOut())
		{
			Robot.launcher.setIsTilterAtBottom(true);
			return true;
		}
		if(up==false&&Robot.tilterLimitSwitch.get())
		{
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
		end();
	}

}
