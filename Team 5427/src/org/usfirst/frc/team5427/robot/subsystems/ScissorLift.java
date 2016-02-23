//This class moves the scissor lift up/down

package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ScissorLift extends Subsystem
{
	
	SpeedController motorScissorLift;
	
	public ScissorLift(SpeedController motorScissorLift)
	{
		this.motorScissorLift=motorScissorLift;
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
		motorScissorLift.set(speed);
	}
}