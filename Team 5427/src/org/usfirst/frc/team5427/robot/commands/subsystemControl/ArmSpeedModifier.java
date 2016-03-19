package org.usfirst.frc.team5427.robot.commands.subsystemControl;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

public class ArmSpeedModifier extends Command {

    /**
     * The axis used to determine speed changes
     * to the arm
     */
    private int axis = Config.ARM_AXIS;

    /**
     * Used to enable 
     */
    private boolean modifiable = false;

    /**
     * This is used if the axis used is as listed from the config
     */
    public ArmSpeedModifier() { }

    public ArmSpeedModifier(int axis) {
        this.axis = axis;
    }

    /**
     * Initialized the command.
     */
    @Override
    protected void initialize() {
        Log.info("Initializing Arm Speed Modifier");
    }

    /**
     * Method is called periodically during execution.
     * This is intentionally empty.
     */
    @Override
    protected void execute() {
        if (modifiable) {
            if (Robot.oi.getJoy().getRawAxis(axis) == -1)
                Config.decreaseArmSpeed();
            else if (Robot.oi.getJoy().getRawAxis(axis) == 1)
                Config.increaseArmSpeed();

            modifiable = false;
        } else if (Robot.oi.getJoy().getRawAxis(axis) == 0)
            modifiable = true;
    }

    /**
     * Returns true once the speed has been modified properly
     *
     * @return true if command has modifiable, false if otherwise
     */
    @Override
    protected boolean isFinished() {
        return modifiable;
    }

    /**
     * Called when isFinished returns true
     */
    @Override
    protected void end() {

    }

    /**
     * Calls when another subsystem is called
     */
    @Override
    protected void interrupted() {
        end();
    }
}
