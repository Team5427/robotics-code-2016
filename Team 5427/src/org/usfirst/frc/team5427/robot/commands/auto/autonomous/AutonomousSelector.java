package org.usfirst.frc.team5427.robot.commands.auto.autonomous;

import org.usfirst.frc.team5427.robot.util.AutonomousMode;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousSelector extends Command {




	public AutonomousSelector(int i) {
		Config.autoMode = i;
		Log.info("AutonomousMode has been selected: " + i);	
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

	}

	@Override
	protected void interrupted() {
end();
	}

	@Override
	protected void initialize() {
		
	}

}
