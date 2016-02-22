
package org.usfirst.frc.team5427.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;

/**
 * Tells the BringInEr subsystem to go on/off
 */
public class StopStuff extends Command {
	
    public StopStuff() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.intaker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intaker.stop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.oi.getJoy().getRawButton(Config.NEW_INTAKE_BUTTON))
			return false;
    	return true;
    }

    // Called once after isFinished returns true
    public void end() {
    	this.setTimeout(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
