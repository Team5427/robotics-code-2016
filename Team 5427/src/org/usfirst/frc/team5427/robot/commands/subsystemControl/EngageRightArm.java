package org.usfirst.frc.team5427.robot.commands.subsystemControl;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class EngageRightArm extends Command {

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
			Robot.rightArm.setRightSpeed(Config.MOVE_SPEED);
		else
			Robot.rightArm.setRightSpeed(-Config.MOVE_SPEED);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		// If button not pressed, returns true and command stops running
		// else returns true and command continues to run
		if (forward && Robot.oi.getJoy().getRawButton(Config.RIGHT_FRONT_ARM_BUTTON) == false)
			return true;
		if (forward == false && Robot.oi.getJoy().getRawButton(Config.RIGHT_BACK_ARM_BUTTON) == false)
			return true;

//		if (!forward && Robot.rightArmPot.get() < 140)
//			return true;
		/*
		 * if (Robot.rightArmPot.get() + Config.MARGIN_TO_SHUT_DOWN >=
		 * Config.MAX_ENDING_POSITION) return true; if (Robot.rightArmPot.get()
		 * - Config.MARGIN_TO_SHUT_DOWN >= Config.MAX_STARTING_POSITION) return
		 * true;
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
