package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Winch extends Subsystem
{
	
	SpeedController winchLeft;
	SpeedController winchRight;
	
	public Winch(SpeedController winchLeft,SpeedController winchRight)
	{
		this.winchLeft = winchLeft;
		this.winchRight = winchRight;
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
		winchLeft.set(speed);
		winchRight.set(speed);
	}
}