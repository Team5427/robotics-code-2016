package org.usfirst.frc.team5427.robot.commands.auto;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.IntakeIn;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.RotateTurret;
import org.usfirst.frc.team5427.robot.network.Client;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class AutoShoot extends Command {

	/**
	 * does not automatically launch a boulder if there is a goal in sight
	 */
	public AutoShoot() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.launcher);
	}

	@Override
	protected void initialize() {
		new MoveBallAwayFromFlyWheels();
		Log.init("initialized Shoot");

	}

	@Override
	protected void execute() {
		new RotateTurret(Client.lastRecievedGoal.getHorizontalAngle());
		new MoveBallAwayFromFlyWheels();
		Robot.launcher.setShootSpeed(Client.lastRecievedGoal.getMotorValue());
		// TODO change the setShootSpeed to use a value from goalData when that
		// is finished
		new IntakeIn();
		
	}



	@Override
	protected boolean isFinished() {
		if (!Robot.oi.getJoy().getRawButton(Config.SHOOT_BUTTON))
			return true;
		else
			return false;
	}

	@Override
	protected void end() {
		Robot.launcher.stopShoot();
		Robot.intake.stop();
		new RotateTurret(0);
	}

	@Override
	protected void interrupted() {

	}

}
