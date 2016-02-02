package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Launcher extends Subsystem{
	SpeedController shooter;
	SpeedController turner;
	SpeedController tilter;
	
	public Launcher(SpeedController shooter, SpeedController turner, SpeedController tilter)
	{
		this.shooter=shooter;
		this.turner=turner;
		this.tilter=tilter;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void stop()
	{
		setTurnSpeed(0);
		setTiltSpeed(0);
		setShootSpeed(0);
		
	}
	
	
	public void setTurnSpeed(double speed)
	{
		turner.set(speed);
	}
	
	public void setTiltSpeed(double speed)
	{
		tilter.set(speed);
	}
	
	public void setShootSpeed(double speed)
	{
		shooter.set(speed);
	}

}
