package org.usfirst.frc.team5427.robot.commands.auto;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.IntakeIn;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.RotateTurret;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.Shoot;
import org.usfirst.frc.team5427.robot.network.Client;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This class shoots the ball at an appropriate speed. This assumes that the
 * turret is already centered to the goal
 */
@Deprecated
public class AutoShoot extends Command {

	public static double timeout = .3;

	private MoveBallAwayFromFlyWheels moveAwayCommand;
	private IntakeIn moveInCommand;

	private long startTime;
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
		startTime  = System.nanoTime();
		moveAwayCommand = new MoveBallAwayFromFlyWheels(.2); // The intake will
																// move away for
																// .3 seconds
		moveAwayCommand.start();

	}

	@Override
	protected void execute() {
		System.out.println(getTime());

		
		if (getTime() > 3000) {
			Robot.intake.go(true);
		}

		Robot.launcher.setShootSpeed(1);

		//
		// // motorValue is used so that when the flywheels are spinning, the
		// shake of the turret
		// // will not distort the distance, thus changing the motorValue sent
		// by the server.
		// if (motorValue == Double.MIN_VALUE)
		// motorValue = 1;
		//// motorValue = Client.getMotorValue();
		//
		// Robot.launcher.setShootSpeed(motorValue);
		//
		// if (startTime == Long.MIN_VALUE) {
		// startTime = System.nanoTime();
		// }
		//
		// // If the time passed is greater than the spin up time, then the ball
		// will be shot
		// if (System.nanoTime() - startTime > Config.SPIN_UP_TIME) {
		// moveInCommand.forceExecute();
		// }
		//
		//// new RotateTurret(Client.lastReceivedGoal.getHorizontalAngle());

	}

	@Override
	protected boolean isFinished() {
		if (getTime() > 7000)
			return true;
		else
			return false;

		/*
		 * if (!Robot.oi.getJoy().getRawButton(Config.SHOOT_BUTTON)) return
		 * true; else return false;
		 */
	}

	@Override
	protected void end() {
		Robot.launcher.stopShoot();
		Robot.intake.stop();
		// new RotateTurret(0).start();
	}

	@Override
	protected void interrupted() {
		end();
	}

	protected int getTime() {
		return (int) ((System.nanoTime() - startTime) / 1000000);
	}

}
