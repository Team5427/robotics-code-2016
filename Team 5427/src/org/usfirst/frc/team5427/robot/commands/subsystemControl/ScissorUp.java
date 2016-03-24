package org.usfirst.frc.team5427.robot.commands.subsystemControl;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class ScissorUp extends Command {

	public ScissorUp() {
		requires(Robot.scissorLift);
		// super.setTimeout(.1);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Log.init("initialized pullUp");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// if(Robot.oi.getJoy().getButton(button))
		// Robot.winch.setSpeed(Config.WINCH_SPEED);
		// latches onto bar
		Robot.scissorLift.move(1);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Robot.oi.getJoy().getRawButton(Config.SCISSORLIFT_UP_BUTTON) == false)
			return true;
		if (Robot.scissorUpLimitSwitch.get())
			return true;

		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.scissorLift.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
