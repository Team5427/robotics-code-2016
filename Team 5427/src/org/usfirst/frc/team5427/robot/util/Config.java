package org.usfirst.frc.team5427.robot.util;

public class Config {
	//MISC
	public static final String NAME = "Team5427RoboCode";
	public static final boolean DEBUG_MODE = false; //displays 'Log.debug' in console
	public static final boolean LOGGING = true; //only logs errors and fatals with this false
	
	//the amount of time AutoGetStuffIn runs
	public static final double AUTO_INTAKE_TIME=5;
	
	
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
	public static final int ULTRASONIC_BUTTON=8;
	public static final int ENGAGE_LEFT_ARM_BUTTON=11;
	public static final int ENGAGE_RIGHT_ARM_BUTTON=12;
	
	
	//PWM PORTS
	public static final int FRONT_LEFT_MOTOR = 0;
	public static final int REAR_LEFT_MOTOR = 1;
	public static final int FRONT_RIGHT_MOTOR = 2;
	public static final int REAR_RIGHT_MOTOR = 3;
	public static final int WINCH_ONE_MOTOR = 4;//Will be 4 & 5
	public static final int WINCH_TWO_MOTOR = 5;
	public static final int SHOOTER_MOTOR = 6;
	public static final int LEFT_ARM_MOTOR=7;
	public static final int RIGHT_ARM_MOTOR=8;
	
	//RELAY PORTS
	public static final int INTAKE_MOTOR=0;	
	public static final int SCISSOR_MOTOR=1;
	public static final int TILT_TURRET_MOTOR = 2;
	public static final int TURN_TURRET_MOTOR = 3;
	
	//LIMIT SWITCH PORTS
	public static final int TILTER_LIMIT_SWITCH=789;
	public static final int SCISSOR_LIMIT_UP=973;
	public static final int SCISSOR_LIMIT_DOWN=888;
	public static final int LEFT_ARM_LIMIT=985;
	public static final int RIGHT_ARM_LIMIT=895;
	
	
	
	
	
	//Potentiometer Analog input port
	public static final int POTENTIOMETER_ANALOG_INPUT= 343;
	//Potentiometer offset
	public static final int POTENTIOMETER_OFFSET=0;
	//Potentiometer's scale (EX: 0V-5V=0deg-360deg)
	public static final int POTENTIOMETER_SCALE=360;
	//Potentiometer reference Degrees
	public static final double POTENTIOMETER_RESET_DEGREES=0;
	//Correct Degrees for tilter
	public static final double TILTER_CORRECT_DEGREES=POTENTIOMETER_RESET_DEGREES+90;
	public static final double TILTER_DEGREES_RANGE=1;
	//Ends of Potentiometer
	public static final double POTENTIOMETER_END_ONE=POTENTIOMETER_RESET_DEGREES;
	public static final double POTENTIOMETER_END_TWO=POTENTIOMETER_END_ONE+180;
	
	
	
	//CONTROLLER PORTS
	public static final int JOYSTICK_PORT = 0;
	public static final int ALT_JOYSTICK_PORT = 0;
	
	//MISC PORTS
	public static final int SONIC_PORT_TRIG=0;
	public static final int SONIC_PORT_ECHO=1;
	
	
	
	
	//OPTIONS
	public static final double INTAKE_SPEED=0.5;
	public static final double LAUNCH_SPEED=0.5;
	public static final double WINCH_SPEED=0.5;
	public static final double SCISSOR_SPEED=0.5;
	public static final double TILT_TIMEOUT=1;
	
	//ROTATION SPEEDS
	public static final double TURNER_SECONDS_PER_DEGREE=.1;
	public static final double TILTER_SECONDS_PER_DEGREE=.1;
	

	//{Turn/Tilt Speed inverse}
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
	
