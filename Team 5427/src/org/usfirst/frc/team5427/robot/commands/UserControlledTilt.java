package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class UserControlledTilt extends Command {
	/**
	 * sets the speed of the tilting mechanism in accordance with the Y axis of the joystick.
	 */
	public UserControlledTilt() {
        // Use requires() here to declare subsystem dependencies
       requires(Robot.launcher);
       requires(Robot.driveTrain);
    }
	
	// Called just before this Command runs the first time
	protected void initialize() {
        Log.info("initialized tilter");
    }
	
// Called repeatedly when this Command is scheduled to run
    
    protected void execute() {
    	//sets the speed of the turning motor
    	if(Robot.oi.getJoy().getThrottle()<-.2)
    		Robot.launcher.setTiltSpeed(-1*Config.TILT_SPEED);
    	if(Robot.oi.getJoy().getThrottle()>.2)
    		Robot.launcher.setTiltSpeed(Config.TILT_SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.oi.getJoy().getRawButton(Config.TO_TURRET_BUTTON) == false){
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.launcher.stopTilt();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

}
