//This class moves the scissor lift up/down

package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ScissorLift extends Subsystem
{
	
	Relay motorScissorLift;
	
	public ScissorLift(Relay motorScissorLift)
	{
		this.motorScissorLift=motorScissorLift;
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void stop()
	{
		motorScissorLift.set(Relay.Value.kOff);
	}
	
	public void move(int direction)
	{
		if(direction<0)
			motorScissorLift.setDirection(Relay.Direction.kReverse);
		else if(direction>0)
			motorScissorLift.setDirection(Relay.Direction.kForward);

		motorScissorLift.set(Relay.Value.kOn);
	}
}