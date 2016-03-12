package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class EngageRightArm extends Command{
	
	public EngageRightArm()
	{
		requires(Robot.doorOpener);
	
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Log.init("initialized RightArm");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
		
		Robot.doorOpener.setRightSpeed(Robot.oi.getJoy().getThrottle());
		
	}

    // Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		//If button not pressed, returns true and command stops running
		//else returns true and command continues to run
		if(Robot.oi.getJoy().getRawButton(Config.ENGAGE_RIGHT_ARM_BUTTON) == false)
			return true;
		if(Robot.rightArmPot.get()+Config.MARGIN_TO_SHUT_DOWN >= Config.MAX_ENDING_POSITION)
			return true;
		if(Robot.rightArmPot.get()-Config.MARGIN_TO_SHUT_DOWN >= Config.MAX_STARTING_POSITION)
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
