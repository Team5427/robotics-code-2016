//This class moves the scissor lift up/down

package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ScissorLift extends Subsystem
{
	
	Relay motorRelay_ScissorLift;
	
	public ScissorLift(Relay motorRelay_ScissorLift)
	{
		this.motorRelay_ScissorLift=motorRelay_ScissorLift;
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void stop()
	{
		motorRelay_ScissorLift.set(Relay.Value.kOff);
	}
	
	public void move(int direction)
	{
		if(direction<0)
			motorRelay_ScissorLift.setDirection(Relay.Direction.kReverse);
		else if(direction>0)
			motorRelay_ScissorLift.setDirection(Relay.Direction.kForward);

		motorRelay_ScissorLift.set(Relay.Value.kOn);
	}
}