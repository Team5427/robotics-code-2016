package org.usfirst.frc.team5427.robot.commands.auto;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.IntakeIn;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.RotateTurret;
import org.usfirst.frc.team5427.robot.network.Client;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This class shoots the ball at an appropriate speed. This assumes that the turret is already centered
 * to the goal
 */
@Deprecated
public class AutoShoot extends Command {

	public static double timeout = .3;

	private MoveBallAwayFromFlyWheels moveAwayCommand;
	private IntakeIn moveInCommand;

	private long startTime = Long.MIN_VALUE;
	private double motorValue = Double.MIN_VALUE;

	/**
	 * does not automatically launch a boulder if there is a goal in sight
	 */
	public AutoShoot() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.launcher);
	}

	@Override
	protected void initialize() {
		Log.init("initialized Shoot");
		moveInCommand = new IntakeIn();
		moveAwayCommand = new MoveBallAwayFromFlyWheels(.3);			// The intake will move away for .3 seconds
		moveAwayCommand.start();

	}

	@Override
	protected void execute() {

		// Prevents the ball to shoot until the the ball is not in contact with the fly wheels
		if (!moveAwayCommand.isFinished())
			return;

		// motorValue is used so that when the flywheels are spinning, the shake of the turret
		// will not distort the distance, thus changing the motorValue sent by the server.
		if (motorValue == Double.MIN_VALUE)
			motorValue = Client.getMotorValue();

		Robot.launcher.setShootSpeed(motorValue);

		if (startTime == Long.MIN_VALUE) {
			startTime = System.nanoTime();
		}

		// If the time passed is greater than the spin up time, then the ball will be shot
		if (System.nanoTime() - startTime > Config.SPIN_UP_TIME) {
			moveInCommand.forceExecute();
		}

//		new RotateTurret(Client.lastReceivedGoal.getHorizontalAngle());

	}



	@Override
	protected boolean isFinished() {
		return !Robot.oi.getJoy().getRawButton(Config.SHOOT_BUTTON);


/*
		if (!Robot.oi.getJoy().getRawButton(Config.SHOOT_BUTTON))
			return true;
		else
			return false;
*/
	}

	@Override
	protected void end() {
		Robot.launcher.stopShoot();
		Robot.intake.stop();
		new RotateTurret(0).start();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
