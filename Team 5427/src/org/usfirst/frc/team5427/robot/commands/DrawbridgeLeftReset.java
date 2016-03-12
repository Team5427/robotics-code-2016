//This should automatically move the arm to grab the door.  
//I do not know if we want the wheels to move automatically 
//to get around this obstacle, but I do not think so
package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class DrawbridgeLeftReset extends Command{
	
	public DrawbridgeLeftReset()
	{
		requires(Robot.doorOpener);
	
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Log.init("initialized DrawbridgeLeftReset");
		Robot.leftEncoder.reset();
	}

	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
		Robot.doorOpener.setLeftSpeed(-.5);
		if(Robot.leftEncoderDirection==Robot.leftEncoder.getDirection())
			Robot.currentPosLeft+=Robot.leftEncoder.getRaw();
		else
		{
			Robot.currentPosLeft-=Robot.leftEncoder.getRaw();
			//Robot.leftEncoderDirection=Robot.leftEncoder.getDirection();
		}
		
		
	}

    // Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if(Robot.currentPosLeft>Config.DRAWBRIDGE_START_POS)
			return false;
		else
		{
			
			return true;
		}
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
