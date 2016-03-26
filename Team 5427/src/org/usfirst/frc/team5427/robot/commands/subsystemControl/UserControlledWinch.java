package org.usfirst.frc.team5427.robot.commands.subsystemControl;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class UserControlledWinch extends Command {

	public UserControlledWinch(){
		requires(Robot.winch);
	}
	
	@Override
	protected void initialize() {
		Log.init("initialized Winch");
	}

	@Override
	protected void execute() {
		Robot.winch.setSpeed(-Robot.oi.getJoy().getY());
	}

	@Override
	protected boolean isFinished() {
		if (Robot.oi.getJoy().getRawButton(Config.WINCH_BUTTON) == false) {
			return true;
		} else
			return false;
	}

	@Override
	protected void end() {
		Robot.winch.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
