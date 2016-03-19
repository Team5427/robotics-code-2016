//This should automatically move the arm to grab the door.  
//I do not know if we want the wheels to move automatically 
//to get around this obstacle, but I do not think so
package org.usfirst.frc.team5427.robot.commands.obstacleSpecific;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class DrawbridgeRightGo extends Command {

	public DrawbridgeRightGo() {
		requires(Robot.rightArm);

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Log.init("initialized DrawbridgeRight");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.rightArm.setRightSpeed(.5);

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Robot.rightArmPot.get() < Config.DRAWBRIDGE_END_POS)
			return false;
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.rightArm.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
