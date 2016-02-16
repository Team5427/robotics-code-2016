package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class UserControlledTurn extends Command {
	/**
	 * set the speed of the motor that rotates the launcher in accordance with the joystick twist axis.
	 */
	public UserControlledTurn() {
        // Use requires() here to declare subsystem dependencies
       requires(Robot.launcher);
    }
	
	// Called just before this Command runs the first time
	protected void initialize() {
        Log.info("initialized turner");
    }
	
// Called repeatedly when this Command is scheduled to run
    
    protected void execute() {

//    	//sets the speed of the turning motor
//    	if(Robot.oi.getJoy().getTwist()<0)
//    	{
//    		Robot.launcher.setTurnSpeed(Config.TURNER_SECONDS_PER_DEGREE);
//    	}
//    	else if(Robot.oi.getJoy().getTwist()>0)
//    	{
//    		Robot.launcher.setTurnSpeed(-1*Config.TURNER_SECONDS_PER_DEGREE);
//    	}

    	//sets the speed of the turning motor MANUALLY
    	if(Robot.oi.getJoy().getTwist()<-.2)
    		Robot.launcher.setTurnSpeed(-1*Config.TURN_SPEED);
    	else if(Robot.oi.getJoy().getTwist()>.2)
    		Robot.launcher.setTurnSpeed(Config.TURN_SPEED);

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.launcher.stopTurn();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

}
