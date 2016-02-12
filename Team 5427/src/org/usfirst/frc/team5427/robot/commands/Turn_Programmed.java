package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class Turn_Programmed extends Command {
	private double targetDegrees;
	Config config;
	/**
	 * set the speed of the motor that rotates the launcher in accordance with the joystick twist axis.
	 */
	public Turn_Programmed(double targetDegrees) {
        // Use requires() here to declare subsystem dependencies
       requires(Robot.launcher);
       this.targetDegrees = targetDegrees;
       initialize();
    }
	
	// Called just before this Command runs the first time
	protected void initialize() {
        Log.info("initialized ProgrammedTurner");
        if(getDegrees()-targetDegrees<0)
    		Robot.launcher.setTurnSpeed(-1*Config.TURN_SPEED);
    	else if(getDegrees()-targetDegrees>0)
    		Robot.launcher.setTurnSpeed(Config.TURN_SPEED);
    }
	
	// Called repeatedly when this Command is scheduled to run
    
    protected void execute() {
    	//sets the speed of the turning motor MANUALLY
    	
    		
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
    	Robot.launcher.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    protected double getDegrees(){
    	return Config.getTurn();
    }

}
