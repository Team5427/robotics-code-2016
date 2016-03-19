//This should reset the arms to the zero position
package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.ArmSpeedDown;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.ArmSpeedUp;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardStuff extends Command {

	
	public SmartDashboardStuff() {
		
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Log.init("initialized Dashboard");
	}

	// The correct current positions of the left and right arms
	// is used to determine how far the arms need to go back
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putData("TEST", new Test());
		SmartDashboard.putData("ArmSpeedDown", new ArmSpeedDown());
		SmartDashboard.putData("ArmSpeedUp", new ArmSpeedUp());
		SmartDashboard.putNumber("Turret Potentiometer Value:", Robot.potentiometer.get());
		SmartDashboard.putNumber("Left Arm Potentiometer Value:", Robot.leftArmPot.get());
		SmartDashboard.putNumber("Right Arm Potentiometer Value:", Robot.rightArmPot.get());
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
