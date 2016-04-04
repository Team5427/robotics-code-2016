package org.usfirst.frc.team5427.robot.commands.auto.autonomous;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.TiltForCollecting;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.TiltForLowBar;

import edu.wpi.first.wpilibj.command.Command;

public class Lowbar extends Command {

	Long timeStarted = System.nanoTime();

	public Lowbar() {
		requires(Robot.driveTrain);

	}

	@Override
	protected void initialize() {
		new TiltForLowBar().start();
	}

	@Override
	protected void execute() {

		if (getTime() < 3100){
			
		}
		else if (getTime() < 4100)
			Robot.driveTrain.driveJoystick(.06, -.5);
		else if (getTime() < 8100)
			Robot.driveTrain.driveJoystick(.05, -.3);

	}

	@Override
	protected boolean isFinished() {
		if (getTime() >= 8100)
			return true;
		return false;
	}

	@Override
	protected void end() {
		Robot.driveTrain.stop();
		new TiltForLowBar().start();
	}

	@Override
	protected void interrupted() {
		end();
	}

	protected int getTime() {
		return (int) ((System.nanoTime() - timeStarted) / 1000000);
	}
	
	public String toString(){
		return "Autonomous Command: Lowbar";
	}

}
