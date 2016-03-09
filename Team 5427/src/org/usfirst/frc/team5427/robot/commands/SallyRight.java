//This should automatically move the arm to grab the door.  
//I do not know if we want the wheels to move automatically 
//to get around this obstacle, but I do not think so
package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class SallyRight extends Command{
	
	public SallyRight()
	{
		requires(Robot.doorOpener);
	
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Log.init("initialized SallyRight");
	}

	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.rightEncoder.reset();
		while(Robot.currentPosRight>Config.SALLY_START_POS)
		{
			Robot.doorOpener.setRightSpeed(-.5);
		}
		if(Robot.rightEncoderDirection==Robot.rightEncoder.getDirection())
			Robot.currentPosRight+=Robot.rightEncoder.getRaw();
		else
		{
			Robot.currentPosRight-=Robot.rightEncoder.getRaw();
			//Robot.rightEncoderDirection=Robot.rightEncoder.getDirection();
		}
		while(Robot.currentPosRight<Config.SALLY_END_POS)
			Robot.doorOpener.setRightSpeed(.5);
		if(Robot.rightEncoderDirection==Robot.rightEncoder.getDirection())
			Robot.currentPosRight+=Robot.rightEncoder.getRaw();
		else
		{
			Robot.currentPosRight-=Robot.rightEncoder.getRaw();
			//Robot.rightEncoderDirection=Robot.rightEncoder.getDirection();
		}
		
		
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
