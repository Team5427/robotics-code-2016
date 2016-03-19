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
	
	public static final int INTAKE_IN_BUTTON = 8;
	public static final int INTAKE_OUT_BUTTON = 7;
	public static final int TILT_COLLECT_BUTTON = 9;
	public static final int TILT_LOW_BAR_BUTTON = 10;
	public static final int SHOOT_BUTTON = 1;
	public static final int SCISSORLIFT_UP_BUTTON = 12;
	public static final int SCISSORLIFT_DOWN_BUTTON = 11;
	public static final int WINCH_BUTTON = 2;
	public static final int TO_TURRET_BUTTON = 2;
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
	public static final int TURRET_MOTOR = 9;

	// RELAY PORTS
	public static final int INTAKE_MOTOR = 0;
	public static final int SCISSOR_MOTOR = 1;
	public static final int TILT_TURRET_MOTOR = 2;
	public static final int TURN_TURRET_MOTOR = 3;

	// LIMIT SWITCH PORTS
	public static final int TILTER_LIMIT_SWITCH = 0;
	public static final int SCISSOR_LIMIT_UP = 973;
	public static final int SCISSOR_LIMIT_DOWN = 888;
	

	// Potentiometer Analog input ports
	public static final int POTENTIOMETER_ANALOG_INPUT = 0;
	public static final int LEFT_POT_PORT = 1;
	public static final int RIGHT_POT_PORT = 2;
	// Potentiometer offsets
	public static final double TURRET_POTENTIOMETER_OFFSET = 4.5;//WHY: 369-360=9/2=4.5 (see POTENTIOMETER_SCALE)
	public static final double LEFT_POT_OFFSET = 0;
	public static final double RIGHT_POT_OFFSET = 0;
	// Potentiometer scales (EX: 0V-5V=0deg-360deg)
	public static final double LEFT_POT_SCALE = 360;	
	public static final double RIGHT_POT_SCALE = 360;
	public static final double TURRET_POTENTIOMETER_SCALE = 369.2307692307692;
	// WHY::large turret gear has 234 teeth, and the small gear for the potentiometer
	// has 24 teeth. 234/24= 9.75 rotations for 360 degrees. THerefore, the
	// potentiometer's 10 rotations is equal to 369.231 degrees {360*10/9.75}
	
	
	// Potentiometers'  Degree references
	// Soft stop values of Potentiometers
		public static final double TURRET_POTENTIOMETER_END_ONE = 220;
		public static final double TURRET_POTENTIOMETER_END_TWO = 313;
		public static final int ARM_START = 0, ARM_END = ARM_START + 180;
		public static final int RIGHT_ARM_MAX_STARTING_POSITION = 0;
		public static final int RIGHT_ARM_MAX_ENDING_POSITION = 180;
		public static final int RIGHT_ARM_MARGIN = 10;
		
		public static final int LEFT_ARM_MAX_STARTING_POSITION = 0;
		public static final int LEFT_ARM_MAX_ENDING_POSITION = 180;
		public static final int LEFT_ARM_MARGIN = 10;
	// Center of the Turret
	public static final double TURRET_CENTER = 267.5;
	public static final double TURRET_CENTER_DEGREES_RANGE = 6;

	//Timeouts for the different types of tilts
		public static final double TILT_COLLECT_TIMEOUT = 6;
		public static final double TILT_LOW_BAR_TIMEOUT = 3;
	
	// CONTROLLER PORTS
		public static final int JOYSTICK_PORT = 0;
		public static final int ALT_JOYSTICK_PORT = 0;
		
	// Speeds for the different things that the robot needs to do
	// TODO a lot of these things can't have their speed changed.
	public static final double INTAKE_SPEED = 0.5;
	public static final double LAUNCH_SPEED = -1;
	public static final double WINCH_SPEED = 0.5;
	public static final double SCISSOR_SPEED = 0.5;	
	
	// DoorOpeners positions to be referenced in their respective commands based
	// on the input from the potentiometers, and
	// Robot.currentLeftPos/Robot.currentRightPos
	
	
	//MIN = 127
	/*public static final int RIGHT_ARM_MAX_STARTING_POSITION = 0;
	public static final int RIGHT_ARM_MAX_ENDING_POSITION = 360;
	public static final int RIGHT_ARM_MARGIN = 10;
	
	public static final int LEFT_ARM_MAX_STARTING_POSITION = 0;
	public static final int LEFT_ARM_MAX_ENDING_POSITION = 360;
	public static final int LEFT_ARM_MARGIN = 10;*/
	// for the different obstacles
	public static final int DRAWBRIDGE_START_POS = 7789;
	public static final int DRAWBRIDGE_END_POS = 7789;
	public static final int SALLY_START_POS = 7789;
	public static final int SALLY_END_POS = 7789;

	

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

	
	
	


//	public static double getTilt() {
//		// TODO get tilt degrees from encoder...which we don't have
//		double tilt = -1;
//		return tilt;
//	}

	public static double getTurn() {

		return Robot.potentiometer.get();
	}

	// Client
	/**
	 * The client used for the robot for connecting to the driver station
	 */
	public static Client client;

}
