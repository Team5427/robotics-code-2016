package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.Talon;

public class SteelTalon extends Talon
{
	/*
	 * SteelTalon is similar to the basic Talon class, but it allows offsets, and allows further edits to the file
	 */
	double backwardoffset, forwardOffset;

	public SteelTalon(int channel)
	{
		super(channel);

		this.backwardoffset = 0;
		this.forwardOffset = 0;
	}
	public SteelTalon(int channel, double backwardOffset, double forwardOffset)
	{
		super(channel);

		this.backwardoffset = backwardOffset;
		this.forwardOffset = forwardOffset;
	}

	public void setBackwardOffset(double backwardOffset)
	{
		this.backwardoffset = backwardOffset;
	}
	
	public void setForwardOffset(double forwardOffset)
	{
		this.forwardOffset = forwardOffset;
	}

	@Override
	public void set(double speed)
	{
		if (speed > .02)
			speed += forwardOffset;
		else if (speed < -.02) speed -= backwardoffset;

		/*
		 * ensures that the speed plus/minus the offset will not exceed the
		 * maximum values that .set can receive
		 */

		if (speed > 1) speed = 1;
		if (speed < -1) speed = -1;
		super.set(speed);
		Feed();
	}

}