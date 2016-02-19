package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.command.Command;

public class UltrasonicLog extends Command{

	public UltrasonicLog()
	{
		requires(Robot.steelUltrasonic);
	}
	
	@Override
	protected void initialize() {
		
		
	}

	@Override
	protected void execute() {
		
		if(Robot.oi.getJoy().getRawButton(11))
		{
			//Robot.steelUltrasonic.ping();
			//Log.init("Distance in Inches"+Robot.steelUltrasonic.getUltrasonicRangeInches());
		}
	}

	@Override
	protected boolean isFinished() {
		
		return false;
	}

	@Override
	protected void end() {
		
		
	}

	@Override
	protected void interrupted() {
		
		
	}

}
