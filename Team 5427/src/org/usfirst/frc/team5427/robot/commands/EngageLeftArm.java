package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class EngageLeftArm extends Command{
	
	boolean forward;
	public EngageLeftArm(boolean forward)
	{
		requires(Robot.doorOpener);
		this.forward=forward;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Log.init("initialized LeftArm");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if(forward)
			Robot.doorOpener.setLeftSpeed(.2);
		else
			Robot.doorOpener.setLeftSpeed(-.2);
	}

    // Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		//If button not pressed, returns true and command stops running
		//else returns true and command continues to run
		if(forward&&Robot.oi.getJoy().getRawButton(Config.LEFT_FRONT) == false)
			return true;
		if(forward==false&&Robot.oi.getJoy().getRawButton(Config.LEFT_BACK) == false)
			return true;
		if(Robot.leftArmPot.get()+Config.MARGIN_TO_SHUT_DOWN >= Config.MAX_ENDING_POSITION)
			return true;
		if(Robot.leftArmPot.get()-Config.MARGIN_TO_SHUT_DOWN >= Config.MAX_STARTING_POSITION)
			return true;
		return false;
	}

    // Called once after isFinished returns true
	protected void end() {
		Robot.doorOpener.stop();
	}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
