package org.usfirst.frc.team5427.robot.commands.auto.autonomous;

import org.usfirst.frc.team5427.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Ramparts extends Command{
	
	Long timeStarted = System.nanoTime();

	@Override
	protected void initialize() {
		requires(Robot.driveTrain);		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
	protected int getTime(){
		return (int)((System.nanoTime()-timeStarted)/1000000);
	}
	
	public String toString(){
		return "Autonomous Command: Ramparts";
	}

}
