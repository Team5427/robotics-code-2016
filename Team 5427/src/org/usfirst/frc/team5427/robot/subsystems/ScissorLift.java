//This class moves the scissor lift up/down

package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ScissorLift extends Subsystem
{
	
	SpeedController lifter;
	
	public ScissorLift(SpeedController lifter)
	{
		this.lifter=lifter;
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
		lifter.set(speed);
	}
}