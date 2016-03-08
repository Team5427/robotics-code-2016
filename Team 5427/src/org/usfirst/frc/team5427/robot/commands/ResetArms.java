
//this is an encoder comand that doesn't work.  Will work on later
package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class ResetArms extends Command{
	int degrees=90;
	
	public ResetArms()
	{
		requires(Robot.doorOpener);
	
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Log.init("initialized ResetArms");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
		//if(degrees<Robot.leftEncoder.get)
	}

    // Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		//If button not pressed, returns true and command stops running
		//else returns true and command continues to run
		if(Robot.oi.getJoy().getRawButton(Config.ENGAGE_LEFT_ARM_BUTTON) == false)
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
