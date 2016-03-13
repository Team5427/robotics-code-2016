package org.usfirst.frc.team5427.robot.util;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.robot.network.Client;

public class Config {

	/*
	 * things TODO defining all of the motors and stuff is fine, however, we
	 * need to properly define the potentiometers, and clean up the old/useless
	 * stuff. This file also needs to be documented so that someone reading it
	 * can easily figure out what every value is for: ex- pretty much everything
	 * to do with potentiometers. It is a huge pain to try to decipher what
	 * someone else had intended for their code to do without proper
	 * documentation.
	 */

	// MISC
	public static final String NAME = "Team5427RoboCode";
	public static final boolean DEBUG_MODE = false; // displays 'Log.debug' in
													// console
	public static final boolean LOGGING = true; // only logs errors and fatals
												// with this false

	// the amount of time AutoGetStuffIn runs
	public static final double AUTO_INTAKE_TIME = 5;

	// Controls
	public static final int JOYSTICK_MODE = 0;
	public static final int ONE_JOYSTICK = 0;
	public static final int TWO_JOYSTICKS = 1;

	// Buttons
	public static final int TOGGLE_INTAKE_BUTTON = 2;
	public static final int INTAKE_IN_BUTTON = 11;
	public static final int INTAKE_OUT_BUTTON = 9;

	public static final int TO_TURRET_BUTTON = 2;
	public static final int SHOOT_BUTTON = 1;
	public static final int SCISSORLIFT_UP_BUTTON = 10;
	public static final int SCISSORLIFT_DOWN_BUTTON = 12;
	public static final int WINCH_BUTTON = 8;
	public static final int LEFT_FRONT = 5, LEFT_BACK = 3;
	public static final int RIGHT_FRONT = 6, RIGHT_BACK = 4;

	// PWM PORTS

	public static final int FRONT_LEFT_MOTOR = 0;
	public static final int REAR_LEFT_MOTOR = 1;
	public static final int FRONT_RIGHT_MOTOR = 2;
	public static final int REAR_RIGHT_MOTOR = 3;
	public static final int WINCH_ONE_MOTOR = 4;
	public static final int WINCH_TWO_MOTOR = 5;
	public static final int SHOOTER_MOTOR = 6;
	public static final int LEFT_ARM_MOTOR = 7;
	public static final int RIGHT_ARM_MOTOR = 8;

	// RELAY PORTS
	public static final int INTAKE_MOTOR = 0;
	public static final int SCISSOR_MOTOR = 1;
	public static final int TILT_TURRET_MOTOR = 2;
	public static final int TURN_TURRET_MOTOR = 3;

	// LIMIT SWITCH PORTS
	public static final int TILTER_LIMIT_SWITCH = 0;
	public static final int SCISSOR_LIMIT_UP = 973;
	public static final int SCISSOR_LIMIT_DOWN = 888;
	// DNE//public static final int LEFT_ARM_LIMIT=985;
	// DNE//public static final int RIGHT_ARM_LIMIT=895;

	// POTENTIOMETER PORTS
	// TODO USE THESE PORTS INSTEAD OF WHATEVER ELSE THERE WAS
	public static final int POTENTIOMETER_TURRET = 0;

	// Potentiometer Analog input port
	// TODO what is this for????
	public static final int POTENTIOMETER_ANALOG_INPUT = 0;

	// TODO rename variables. We have three potentiometers...
	// Potentiometer offset
	// 369-360=9/2=4.5 (see POTENTIOMETER_SCALE)
	public static final double POTENTIOMETER_OFFSET = 4.5;
	// Potentiometer's scale (EX: 0V-5V=0deg-360deg)
	// large turret gear has 234 teeth, and the small gear for the potentiometer
	// has
	// 24 teeth. 234/24= 9.75 rotations for 360 degrees. THerefore, the
	// potentiometer's 10 rotations is equal to 369.231 degrees {360*10/9.75}
	public static final double POTENTIOMETER_SCALE = 369.2307692307692;
	// Potentiometer reference Degrees
	public static final double POTENTIOMETER_RESET_DEGREES = 0;
	// Correct Degrees for tilter
	public static final double TILTER_CORRECT_DEGREES = 267.5;
	public static final double TILTER_DEGREES_RANGE = 1;
	// Ends of Potentiometer
	public static final double POTENTIOMETER_END_ONE = 174;
	public static final double POTENTIOMETER_END_TWO = 360;

	// Arms' stop/end spots
	public static final int ARM_START = 0, ARM_END = ARM_START + 180;

	// Arm potentiometer ports
	public static final int LEFT_POT_PORT = 1;
	public static final double LEFT_POT_SCALE = 360;
	public static final double LEFT_POT_OFFSET = 0;

	public static final int RIGHT_POT_PORT = 2;
	public static final double RIGHT_POT_SCALE = 360;
	public static final double RIGHT_POT_OFFSET = 0;

	// DoorOpeners positions to be referenced in their respective commands based
	// on
	// the input from the encoders, and
	// Robot.currentLeftPos/Robot.currentRightPos
	public static final int MAX_STARTING_POSITION = 0;
	public static final int MAX_ENDING_POSITION = 360;
	public static final int MARGIN_TO_SHUT_DOWN = 10;
	// for the different obstacles
	public static final int DRAWBRIDGE_START_POS = 7789;
	public static final int DRAWBRIDGE_END_POS = 7789;
	public static final int SALLY_START_POS = 7789;
	public static final int SALLY_END_POS = 7789;

	// CONTROLLER PORTS
	public static final int JOYSTICK_PORT = 0;
	public static final int ALT_JOYSTICK_PORT = 0;

	// stores the speed, in feet per second, that the Robot travels at full
	// speed
	// TODO time these values
	// TODO use feet, nobody uses meters....
	public static final int FULL_SPEED_FORWARD = 1;
	public static final int FULL_SPEED_BACKWARD = 1;
	public static final int FULL_TURN_SPEED_RIGHT = 1;
	public static final int FULL_TURN_SPEED_LEFT = 1;
	// AUTO STUFF
	// TODO time these values
	public static final double OBSTACLE_TIME = 3;

	// OPTIONS
	// TODO a lot of these things can't have their speed changed.
	public static final double INTAKE_SPEED = 0.5;
	public static final double LAUNCH_SPEED = 0.5;
	public static final double WINCH_SPEED = 0.5;
	public static final double SCISSOR_SPEED = 0.5;
	public static final double TILT_TIMEOUT = .1;

	// ROTATION SPEEDS
	public static final double TURNER_SECONDS_PER_DEGREE = .1;
	public static final double TILTER_SECONDS_PER_DEGREE = .1;

	// {Turn/Tilt Speed inverse}
	public static final double TURN_SPEED = .1;
	public static final double TILT_SPEED = .1;

	// Shooter time run
	public static final int SHOOTER_SECONDS = 2;

	// MEASUREMENTS

	public static double getTilt() {
		// TODO get tilt degrees from encoder
		double tilt = -1;
		return tilt;
	}

	public static double getTurn() {

		return Robot.potentiometer.get();
	}

	// Client
	public static Client client;

}
