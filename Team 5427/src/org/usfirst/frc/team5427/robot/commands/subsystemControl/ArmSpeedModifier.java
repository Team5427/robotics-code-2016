package org.usfirst.frc.team5427.robot.commands.subsystemControl;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

public class ArmSpeedModifier extends Command {

    /**
     * Used to prevent the speed to change until axis is 0
     */
    private boolean modifiable = true;

    /**
     * This is used if the axis used is as listed from the config
     */
    public ArmSpeedModifier() { }

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
//    	Log.info("Executing arm speed");
        if (modifiable) {
        	if (Robot.oi.getJoy().getPOV(0) == 270) {
            	Log.info("Decreasing arm speed");
                Config.decreaseArmSpeed();
                modifiable = false;
            }
            else if (Robot.oi.getJoy().getPOV(0) == 90) {
            	Log.info("Increasing arm speed");
            	Config.increaseArmSpeed();
                modifiable = false;
            }
        } else if (Robot.oi.getJoy().getPOV(0) == -1) {
            modifiable = true;
        }
    }

    /**
     * Returns true once the speed has been modified properly
     *
     * @return true if command has modifiable, false if otherwise
     */
    @Override
    protected boolean isFinished() {
        return false ;
    }

    /**
     * Called when isFinished returns true
     */
    @Override
    protected void end() {
        modifiable = true;
    }

    /**
     * Calls when another subsystem is called
     */
    @Override
    protected void interrupted() {
        end();
    }
}
