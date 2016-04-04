package org.usfirst.frc.team5427.robot.commands.auto.autonomous;

import org.usfirst.frc.team5427.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Rockwall extends Command {

	Long timeStarted = System.nanoTime();

	public Rockwall() {
		requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		if (getTime() < 1000)
			Robot.driveTrain.driveJoystick(.05, -.5);
		else if(getTime() < 3000)
			Robot.driveTrain.driveJoystick(.07, -.8);
//		else
//			Robot.driveTrain.driveJoystick(.005, -.7);
	}

	@Override
	protected boolean isFinished() {
		if (getTime() >= 3000)
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
		return "Autonomous Command: Rockwall";
	}

}
