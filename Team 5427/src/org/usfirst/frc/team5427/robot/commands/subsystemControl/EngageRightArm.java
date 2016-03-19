package org.usfirst.frc.team5427.robot.commands.subsystemControl;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class EngageRightArm extends Command {

	/**
	 * Max speed of the arm to move
	 */
	public static final double MAX_SPEED 	  = .4;
	/**
	 * Minimum speed of the arm to move
	 */
	public static final double MIN_SPEED 	  = .1;
	/**
	 * The interval of the speed that will change
	 */
	public static final double SPEED_INTERVAL = .1;

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

	/**
	 * Increases the speed of the arm based on the interval
	 */
	public static void speedUp() {
		moveSpeed += SPEED_INTERVAL;

		if (moveSpeed > MAX_SPEED)
			moveSpeed = MAX_SPEED;
	}

	/**
	 * Decreases the speed of the arm based on the interval
	 */
	public static void speedDown() {
		moveSpeed -= SPEED_INTERVAL;

		if (moveSpeed < MIN_SPEED)
			moveSpeed = MIN_SPEED;
	}
}
