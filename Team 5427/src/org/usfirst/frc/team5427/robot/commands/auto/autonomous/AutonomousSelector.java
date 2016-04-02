package org.usfirst.frc.team5427.robot.commands.auto.autonomous;

import org.usfirst.frc.team5427.robot.util.AutonomousMode;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousSelector extends Command {

	public AutonomousSelector(Object o) {
		Config.autoMode = (AutonomousMode) o;
		Log.info("AutonomousMode has been selected: " + (AutonomousMode) o);
	}

	protected void AutomousSelector(AutonomousMode auto) {

	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}

	@Override
	protected void initialize() {
	}

}
