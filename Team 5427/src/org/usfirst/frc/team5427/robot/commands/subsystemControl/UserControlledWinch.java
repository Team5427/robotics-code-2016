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
		if(Robot.oi.getJoy().getPOV()==0)
			Robot.winch.setSpeed(1);
		else if((Robot.oi.getJoy().getPOV()==180))
			Robot.winch.setSpeed(-1);
		else
			Robot.winch.setSpeed(0);
	}

	@Override
	protected boolean isFinished() {
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
