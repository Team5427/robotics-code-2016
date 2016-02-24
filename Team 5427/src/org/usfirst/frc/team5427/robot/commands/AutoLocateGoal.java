package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class AutoLocateGoal extends Command {

	@Override
	protected void initialize() {
		Log.init("initialized AutoLocateGoal");
				
	}

	@Override
	protected void execute() {
				
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		AutoLaunchBoulder autoLaunchBoulder= new AutoLaunchBoulder();
		autoLaunchBoulder.start();
	}

	@Override
	protected void interrupted() {
				
	}

}
