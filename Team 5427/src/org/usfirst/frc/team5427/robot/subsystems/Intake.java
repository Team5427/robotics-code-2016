package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{
	
	SpeedController intakeLeft;
	SpeedController intakeRight;
	
	public Intake(SpeedController left, SpeedController right){
		intakeLeft = left;
		intakeRight = right;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void stop(){
		intakeLeft.set(0);
		intakeRight.set(0);
	}
	
	public void setSpeed(double speed){
		intakeLeft.set(speed);
		intakeRight.set(speed*-1);
	}
	
	

}
