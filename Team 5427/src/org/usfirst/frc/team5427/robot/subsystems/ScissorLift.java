//This class moves the scissor lift up/down

package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ScissorLift extends Subsystem {

	Relay motorRelay_ScissorLift;
	//The below limits DO NOT EXIST on the Robot
	DigitalInput scissorLimitUp, scissorLimitDown;

	/**
	 * Scissorlift constructor -- parameter is the motor.
	 * 
	 * @param motorRelay_ScissorLift
	 */
	public ScissorLift(Relay motorRelay_ScissorLift, DigitalInput scissorLimitUp, DigitalInput scissorLimitDown) {
		this.motorRelay_ScissorLift = motorRelay_ScissorLift;
		this.scissorLimitUp = scissorLimitUp;
		this.scissorLimitDown = scissorLimitDown;

	}
	
	
	//below is the correct construcot that we should use because we do not have any limit switches
	/*public ScissorLift(Relay motorRelay_ScissorLift) {
		this.motorRelay_ScissorLift = motorRelay_ScissorLift;
	}*/

	@Override
	protected void initDefaultCommand() {

	}

	/**
	 * turns off the motor
	 */
	public void stop() {
		motorRelay_ScissorLift.set(Relay.Value.kOff);
	}

	/**
	 * moves the scissorlift motor, if the direction is >0 it goes forward,
	 * otherwise back.
	 * 
	 * @param direction
	 */
	public void move(int direction) {
		/*
		// Note: (May have to switch the kReverse and kForard if our directions
		// are messed up...)
		// Going down
		if (direction < 0 && scissorLimitDown.get() == false)
			motorRelay_ScissorLift.setDirection(Relay.Direction.kReverse);
		// Going up
		else if (direction > 0 && scissorLimitUp.get() == false)
			motorRelay_ScissorLift.setDirection(Relay.Direction.kForward);
		else
			stop();

*/
		System.out.println("moving the scissorLift");
		if (direction < 0){
			motorRelay_ScissorLift.setDirection(Relay.Direction.kReverse);
			System.out.println("GOING DOWN W/ scissorlift");
			//motorRelay_ScissorLift.set(Relay.Value.kOn);
		}
		// Going up
		else if (direction > 0){
			motorRelay_ScissorLift.setDirection(Relay.Direction.kForward);
			System.out.println("GOING UP W/ scissorlift");
			//motorRelay_ScissorLift.set(Relay.Value.kOn);
		}
		else
			stop();
		//the below line of code should probably not exist...but maybe it will be OK
		motorRelay_ScissorLift.set(Relay.Value.kOn);
	}
}