package org.usfirst.frc.team5427.robot.util;

public class Config {
	//MISC
	public static final String NAME = "Team5427RoboCode";
	
	
	public static final boolean DEBUG_MODE = false; //displays 'Log.debug' in console
	public static final boolean LOGGING = true; //only logs errors and fatals with this false
	
	//Controls
	public static final int JOYSTICK_MODE = 0;
	public static final int ONE_JOYSTICK = 0;
	public static final int TWO_JOYSTICKS = 1;
	
	//Buttons
	public static final int TOGGLE_INTAKE_BUTTON = 2;
	public static final int NEW_INTAKE_BUTTON = 10;
	public static final int TO_TURRET_BUTTON=2;
	public static final int SHOOT_BUTTON=1;
	public static final int SCISSORLIFT_UP_BUTTON=3;
	public static final int SCISSORLIFT_DOWN_BUTTON=4;
	public static final int WINCH_BUTTON=5;
	public static final int ULTRASONIC_BUTTON=11;
	
	//PORTS FOR VARIOUS THINGS
	public static final int FRONT_LEFT_MOTOR = 0;
	public static final int REAR_LEFT_MOTOR = 1;
	public static final int FRONT_RIGHT_MOTOR = 2;
	public static final int REAR_RIGHT_MOTOR = 3;
	public static final int TILT_TURRET_MOTOR = 6;
	public static final int TURN_TURRET_MOTOR = 7;
	public static final int SHOOTER_MOTOR = 8;

	public static final int WINCH_ONE_MOTOR = 4;//Will be 4 & 5
	public static final int WINCH_TWO_MOTOR = 5;
	
	public static final int RELAY_PORT=1;
	
	public static final int SCISSOR_MOTOR=9;
	
	public static final int SONIC_PORT_TRIG=0;
	public static final int SONIC_PORT_ECHO=1;
	
	public static final int JOYSTICK_PORT = 0;
	
	public static final int ALT_JOYSTICK_PORT = 0;
	
	//OPTIONS
	public static final double INTAKE_SPEED=0.5;
	public static final double LAUNCH_SPEED=0.5;
	public static final double WINCH_SPEED=0.5;
	public static final double SCISSOR_SPEED=0.5;
	
	//degree speeds
	public static final double TURNER_SECONDS_PER_DEGREE=.1;
	public static final double TILTER_SECONDS_PER_DEGREE=.1;
	
	//other{Turn/Tild Speed inverse}
	public static final double TURN_SPEED=.1;
	public static final double TILT_SPEED=.1;
	
	//Shooter time run
	public static final int SHOOTER_SECONDS=500;
	
	
	//MEASUREMENTS
	
	public static double getTilt() {
		// TODO get tilt degrees from encoder
		double tilt = -1;
		return tilt;
	}
	
	public static double getTurn() {
		//TODO get turn degrees from encoder
		double turn = -1;
		return turn;
	}
	
	
	

	}
	