package org.usfirst.frc.team5427.robot.commands.subsystemControl;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.network.Client;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {

	private double shootSpeed;

	/**
	 * sets the speed of the launching mechanism to the speed defined in the
	 * configuration file.
	 */
	public Shoot() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.launcher);
		
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Log.init("initialized Shoot");
		if (Config.ENABLE_GRIP_SHOOT)
			shootSpeed = Client.getMotorValue();
		else
			shootSpeed = Config.LAUNCH_SPEED;

		Robot.launcher.setShootSpeed(shootSpeed);
	}

	// Called repeatedly when this Command is scheduled to run

	protected void execute() {
		Robot.launcher.setShootSpeed(shootSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if(!Robot.oi.getJoy().getRawButton(Config.SHOOT_BUTTON)) return true;
		else return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.launcher.stopShoot();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

}
