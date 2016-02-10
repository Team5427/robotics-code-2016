package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class Turn_Programmed extends Command {
	private double degrees;
	private double targetDegrees;
	/**
	 * set the speed of the motor that rotates the launcher in accordance with the joystick twist axis.
	 */
	public Turn_Programmed(double degrees, double targetDegrees) {
        // Use requires() here to declare subsystem dependencies
       requires(Robot.launcher);
       this.degrees = degrees;
       this.targetDegrees = targetDegrees;
    }
	
	// Called just before this Command runs the first time
	protected void initialize() {
        Log.info("initialized ProgrammedTurner");
        long startTime = System.nanoTime(); //TODO use timers: http://www.java2s.com/Code/Java/Development-Class/UsejavautilTimertoscheduleatasktoexecuteonce5secondshavepassed.htm
        // in order to complete this, then rewrite the other programmed java files in same way.
    }
	
	// Called repeatedly when this Command is scheduled to run
    
    protected void execute() {
    	//sets the speed of the turning motor MANUALLY
    	if(degrees-targetDegrees<0)
    		Robot.launcher.setTurnSpeed(-1*Config.TURN_SPEED);
    	else if(degrees-targetDegrees>0)
    		Robot.launcher.setTurnSpeed(Config.TURN_SPEED);
    		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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

}
