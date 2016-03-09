//resets the CurrentPosLeft && CurrentPosRight to 0 in order to restart the count.
//Also sets the encoders' counts to zero

package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class ResetEncoders extends Command{
	
	
	public ResetEncoders()
	{
		initialize();
	
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Log.init("initialized ResetEncoders");
		Robot.currentPosLeft=Robot.currentPosRight=0;
		Robot.leftEncoderDirection=Robot.leftEncoder.getDirection();
		Robot.rightEncoderDirection=Robot.rightEncoder.getDirection();
		Robot.leftEncoder.reset();
		Robot.rightEncoder.reset();
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
		
	}

    // Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
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
