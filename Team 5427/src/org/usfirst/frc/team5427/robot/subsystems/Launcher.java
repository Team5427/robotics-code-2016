package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * the launcher subsystem is used for controlling the mechanism that launches boulders, and involves 
 * 3 different parts, the shooting motors, turning motors, and angling/tilting motors. 
 * @author team5427
 *
 */
public class Launcher extends Subsystem{
	SpeedController shooter;
	SpeedController turner;
	SpeedController tilter;
	/**
	 * launcher constructor -- takes motors for various parts of the launcher as parameters
	 * @param shooter
	 * @param turner
	 * @param tilter
	 */
	public Launcher(SpeedController shooter, SpeedController turner, SpeedController tilter)
	{
		this.shooter=shooter;
		this.turner=turner;
		this.tilter=tilter;
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
	/**
	 * sets all of the motor speeds to 0
	 */
	public void stop()
	{
		setTurnSpeed(0);
		setTiltSpeed(0);
		setShootSpeed(0);
		
	}
	
	/**
	 * sets the speed of the turning motors to the specified speed.
	 * @param speed
	 */
	public void setTurnSpeed(double speed)
	{
		turner.set(speed);
	}
	/**
	 * sets the speed of the tilting motors to the specified speed.
	 * @param speed
	 */
	public void setTiltSpeed(double speed)
	{
		tilter.set(speed);
	}
	/**
	 * sets the speed of the shooting motors to the specified speed.
	 * @param speed
	 */
	public void setShootSpeed(double speed)
	{
		shooter.set(speed);
	}

}
