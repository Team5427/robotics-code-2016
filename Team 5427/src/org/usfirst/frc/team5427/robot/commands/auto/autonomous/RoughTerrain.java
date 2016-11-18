package org.usfirst.frc.team5427.robot.commands.auto.autonomous;

import org.usfirst.frc.team5427.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RoughTerrain extends Command {

	Long timeStarted = System.nanoTime();

	public RoughTerrain() {
		requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		if (getTime() < 1000)
			Robot.driveTrain.driveJoystick(.02, -.7);
		else
			Robot.driveTrain.driveJoystick(.02, -.7);
	}

	@Override
	protected boolean isFinished() {
		if (getTime() >= 3500)
			return true;
		return false;
	}

	@Override
	protected void end() {
		Robot.driveTrain.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

	protected int getTime() {
		return (int) ((System.nanoTime() - timeStarted) / 1000000);
	}
	
	public String toString(){
		return "Autonomous Command: RoughTerrain";
	}

}
