package org.usfirst.frc.team5427.robot.subsystems;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.SteelTalon;
import org.usfirst.frc.team5427.robot.util.Config;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This Subsystem will be responsible for managing all four SIM motors that are
 * responsible for controlling the wheels.
 *		//TODO expand on this description once more is known about the robot.
 * @author team5427
 */
public class BringInEr extends Subsystem {

	Relay bringer;
	
	
	/**
	 * BringInEr constructor -- as parameters takes each motor to initialise.
	 * @param bringer
	 */
	public BringInEr(Relay bringer)
	{
		this.bringer= bringer;
		bringer.setDirection(Relay.Direction.kReverse);
	}
	@Override
	protected void initDefaultCommand() {
		

	}
	/**
	 *Makes it power on
	 */
	public void go()
	{bringer.set(Relay.Value.kOn);}
	
	 //* Makes it power off
	 //*/
	public void stop()
	{bringer.set(Relay.Value.kOff);}
}
	