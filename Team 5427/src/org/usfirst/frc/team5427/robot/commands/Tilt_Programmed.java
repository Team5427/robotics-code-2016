//never used, will not work because there getTilt() in Config doesn't work.
//Need to code lots of things to make getTilt() work, and I don't think we're going to use this command anyway

package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class Tilt_Programmed extends Command {
	private double targetDegrees;
	/**
	 * sets the speed of the tilting mechanism in accordance with the Y axis of the joystick.
	 * @param targetDegrees - the degree value to reach before stopping command.
	 */
	
	public Tilt_Programmed(double targetDegrees) {
        // Use requires() here to declare subsystem dependencies
       requires(Robot.launcher);
       requires(Robot.driveTrain);
       this.targetDegrees=targetDegrees;
       initialize();
    }
	
	// Called just before this Command runs the first time
	/**
	 * sets the speed of the tilt to tilt the correct direction. the tilt is stopped when the command ends.
	 */
	protected void initialize() {
        Log.init("initialized tilter");
        if(getDegrees()-targetDegrees<0)
    		Robot.launcher.setTiltSpeed(-1*Config.TILT_SPEED);
    	else if(getDegrees()-targetDegrees>0)
    		Robot.launcher.setTiltSpeed(Config.TILT_SPEED);
    }
	
// Called repeatedly when this Command is scheduled to run
    
    protected void execute() {
   	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(getDegrees()-targetDegrees==0){
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
    
    protected double getDegrees(){
    	return Config.getTilt();
    }

}
