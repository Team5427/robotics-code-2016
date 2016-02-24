package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Winch extends Subsystem
{
	
	SpeedController motorWinchLeft;
	SpeedController motorWinchRight;
	
	public Winch(SpeedController motorWinchLeft,SpeedController motorWinchRight)
	{
		this.motorWinchLeft = motorWinchLeft;
		this.motorWinchRight = motorWinchRight;
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
		motorWinchLeft.set(speed);
		motorWinchRight.set(speed);
	}
}