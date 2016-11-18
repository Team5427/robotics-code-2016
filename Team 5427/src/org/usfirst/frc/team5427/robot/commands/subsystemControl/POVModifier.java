package org.usfirst.frc.team5427.robot.commands.subsystemControl;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

/**
 * This class involves controlling systems in the robot using the
 * joystick's POV HAT switch.
 */
public class POVModifier extends Command {

	/**
	 * Used to prevent the speed to change until axis is 0
	 */
	private boolean speedModifiable = true;

	/**
	 * Used to prevent a single command to keep starting when
	 * execute is called in this class
	 */
	private boolean armSyncMoving = false;

	// TODO: Comment
	private EngageLeftArm leftArm = new EngageLeftArm(true);
	private EngageRightArm rightArm = new EngageRightArm(true);

	/**
	 * This is used if the axis used is as listed from the config
	 */
	public POVModifier() {
	}

	/**
	 * Initialized the command.
	 */
	@Override
	protected void initialize() {
		Log.info("Initializing Arm Speed Modifier");
	}

	/**
	 * Returns true once the speed has been modified properly
	 *
	 * @return true if command has speedModifiable, false if otherwise
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}

	/**
	 * Called when isFinished returns true
	 */
	@Override
	protected void end() {

	}

	/**
	 * Method is called periodically during execution. This is intentionally
	 * empty.
	 */
	@Override
	protected void execute() {
//		L
//		og.info("Execute POV Modifier");
		
		/*if (leftArm.isFinished() || rightArm.isFinished()) {
			Log.info("Commands are finished");
			if (Robot.oi.getJoy().getPOV(0) == 0) {
				Log.info("Moved arms");
				leftArm.setForward(true);
				rightArm.setForward(true);
				leftArm.start();
				rightArm.start();
			}
		}
*/
		// Log.info("Executing arm speed");


		if (speedModifiable) {
			if (Robot.oi.getJoy().getPOV(0) == 270) {
				Log.info("Decreasing arm speed");
				Config.decreaseArmSpeed();
				speedModifiable = false;
			} else if (Robot.oi.getJoy().getPOV(0) == 90) {
				Log.info("Increasing arm speed");
				Config.increaseArmSpeed();
				speedModifiable = false;
			}
		} else if (Robot.oi.getJoy().getPOV(0) == -1) {
			speedModifiable = true;
		}
	}

	/**
	 * Calls when another subsystem is called
	 */
	@Override
	protected void interrupted() {
		end();
	}
}
