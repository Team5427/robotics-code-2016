package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Winch extends Subsystem
{
	
	SpeedController motorPWM_WinchOne;
	SpeedController motorPWM_WinchTwo;
	
	public Winch(SpeedController motorPWM_Winch1,SpeedController motorPWM_Winch2)
	{
		this.motorPWM_WinchOne = motorPWM_Winch1;
		this.motorPWM_WinchTwo = motorPWM_Winch2;
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void stop()
	{
		setSpeed(0);
	}
	
	public void setSpeed(double speed)
	{
		motorPWM_WinchOne.set(speed);
		motorPWM_WinchTwo.set(speed);
	}
}