package org.usfirst.frc.team5427.robot.commands.auto.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class Nothing extends Command {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		end();
	}

	public String toString() {
		return "Autonomous Command: Nothing";
	}

}
