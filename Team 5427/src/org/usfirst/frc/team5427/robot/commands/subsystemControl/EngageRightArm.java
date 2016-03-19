package org.usfirst.frc.team5427.robot.commands.subsystemControl;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class EngageRightArm extends Command {

	
	/**
	 * Current speed of the right arm to move
	 */
	public static double moveSpeed = .2;

	boolean forward;

	public EngageRightArm(boolean forward) {
		requires(Robot.rightArm);
		this.forward = forward;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Log.init("initialized RightArm");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (forward) 
			Robot.rightArm.setRightSpeed(moveSpeed);
		else
			Robot.rightArm.setRightSpeed(-moveSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		// If button not pressed, returns true and command stops running
		// else returns true and command continues to run
		if (forward && Robot.oi.getJoy().getRawButton(Config.RIGHT_FRONT) == false)
			return true;
		if (forward == false && Robot.oi.getJoy().getRawButton(Config.RIGHT_BACK) == false)
			return true;
		
		if(!forward && Robot.rightArmPot.get() < 165)
			return true;
		/*
		if (Robot.rightArmPot.get() + Config.MARGIN_TO_SHUT_DOWN >= Config.MAX_ENDING_POSITION)
			return true;
		if (Robot.rightArmPot.get() - Config.MARGIN_TO_SHUT_DOWN >= Config.MAX_STARTING_POSITION)
			return true;
			*/
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.rightArm.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

	
}
