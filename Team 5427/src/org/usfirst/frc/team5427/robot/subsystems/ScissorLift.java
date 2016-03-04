//This class moves the scissor lift up/down

package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ScissorLift extends Subsystem
{
	
	Relay motorRelay_ScissorLift;
	
	/**
	 * Scissorlift constructor -- parameter is the motor.
	 * @param motorRelay_ScissorLift
	 */
	public ScissorLift(Relay motorRelay_ScissorLift)
	{
		this.motorRelay_ScissorLift=motorRelay_ScissorLift;
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
	/**
	 * turns off the motor
	 */
	public void stop()
	{
		motorRelay_ScissorLift.set(Relay.Value.kOff);
	}
	/**
	 * moves the scissorlift motor, if the direction is >0 it goes forward, otherwise back.
	 * @param direction
	 */
	public void move(int direction)
	{
		if(direction<0)
			motorRelay_ScissorLift.setDirection(Relay.Direction.kReverse);
		else if(direction>0)
			motorRelay_ScissorLift.setDirection(Relay.Direction.kForward);
		else stop();

		motorRelay_ScissorLift.set(Relay.Value.kOn);
	}
}