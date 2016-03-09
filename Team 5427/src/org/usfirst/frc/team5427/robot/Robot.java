
package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5427.robot.commands.AutoLaunchBoulder;
import org.usfirst.frc.team5427.robot.commands.AutoLocateGoal;
import org.usfirst.frc.team5427.robot.commands.Drive;
import org.usfirst.frc.team5427.robot.commands.GetStuffIn;
import org.usfirst.frc.team5427.robot.commands.ResetEncoders;
import org.usfirst.frc.team5427.robot.commands.SonicDist;
import org.usfirst.frc.team5427.robot.commands.UserControlledTurn;
import org.usfirst.frc.team5427.robot.commands.resetTiltUp;
import org.usfirst.frc.team5427.robot.subsystems.Intake;
import org.usfirst.frc.team5427.robot.subsystems.DoorOpener;
import org.usfirst.frc.team5427.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5427.robot.subsystems.Intake;
import org.usfirst.frc.team5427.robot.subsystems.Launcher;
import org.usfirst.frc.team5427.robot.subsystems.ScissorLift;
import org.usfirst.frc.team5427.robot.subsystems.SteelUltrasonic;
import org.usfirst.frc.team5427.robot.subsystems.Winch;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    
	
	
	
	
 // TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * Motor utilized in the DriveTrain. It is located in the front left of the
 	 * robot from a top-down point of view, and setting the speed of this motor
 	 * to a positive value will cause the robot to move __________
 	 */
 	static SpeedController motorPWM_FrontLeft;
 	
 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * Motor utilized in the DriveTrain. It is located in the rear left of the
 	 * robot from a top-down point of view, and setting the speed of this motor
 	 * to a positive value will cause the robot to move __________
 	 */
 	static SpeedController motorPWM_RearLeft;
 	
 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * Motor utilized in the DriveTrain. It is located in the front right of the
 	 * robot from a top-down point of view, and setting the speed of this motor
 	 * to a positive value will cause the robot to move __________
 	 */
 	static SpeedController motorPWM_FrontRight;
 	
 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * Motor utilized in the DriveTrain. It is located in the rear right of the
 	 * robot from a top-down point of view, and setting the speed of this motor
 	 * to a positive value will cause the robot to move __________
 	 */
 	static SpeedController motorPWM_RearRight;
 	
 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * Motor that powers the FlyWheel which is responsible for launching the
 	 * boulder from the robot on contact. Setting it to a positive speed will
 	 * make it make the wheel spin __________ relative to the front of the
 	 * shooting mechanism.
 	 */
 	static SpeedController motorPWM_Flywheel;

 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * Motor that controls the movement of the left arm on the robot, moving it
 	 * either forwards or backwards. Setting its speed to a positive value will
 	 * cause the arm to move _________
 	 */
 	static SpeedController motorPWM_LeftArm;
 	
 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * Motor that controls the movement of the right arm on the robot, moving it
 	 * either forwards or backwards. Setting its speed to a positive value will
 	 * cause the arm to move _________
 	 */
 	static SpeedController motorPWM_RightArm;

 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * One of the two motors that is responsible for controlling the winch on
 	 * the robot. This is the motor that is located closer to the front of the
 	 * robot, and setting its speed to 1 will cause the spool of wire to
 	 * _________
 	 */
 	static SpeedController motorPWM_WinchOne;
 	
 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * One of the two motors that is responsible for controlling the winch on
 	 * the robot. This is the motor that is located closer to the front of the
 	 * robot, and setting its speed to 1 will cause the spool of wire to
 	 * _________
 	 */
 	static SpeedController motorPWM_WinchTwo;

 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * A small motor that is attached to the front of the shooting mechanism and
 	 * is meant to turn a set of wheels that will intake the ball. Setting this
 	 * to forwards will make the intake __________ incoming boulders.
 	 */
 	static Relay motorRelay_Intake;
 	
 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * A small motor that is meant to rotate the turret. Setting the motor to
 	 * forwards will make the turret turn ________
 	 */
 	static Relay motorRelay_RotateTurret;
 	
 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * A small motor that is meant to tilt the turret. Setting it to forwards
 	 * will make the turret tilt _________
 	 */
 	static Relay motorRelay_TiltTurret;
 	
 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * A small motor that is mean to extend/retract the scissor lift at the back
 	 * of the robot. Setting the direction to forwards will cause the scissor
 	 * lift to move ___________
 	 */
 	static Relay motorRelay_ScissorLift;


	Thread ultrasonicThread;
	
	 Drive drive;
	 SonicDist sonicDist;
	 //new intake system
	 //public static GetStuffIn getStuff;
	 //stores distance in inches from the object
	 public static double distanceInInches;
	 
	//UserControlledTurn turn;
	AutoLaunchBoulder autoLaunchBoulder;
	
	public static Launcher launcher;
	public static Winch winch;
	public static ScissorLift scissorLift;
	public static OI oi;
	public static SteelUltrasonic steelUltrasonic;
	public static Intake intake;
	
	public static DriveTrain driveTrain;
	public static DoorOpener doorOpener;

	public static Ultrasonic mySonic;
	
	double turnDegrees;
	double tiltDegrees;
	
	//Limit switches
	public static DigitalInput tilterLimitSwitch;
	public static DigitalInput scissorUpLimitSwitch;
	public static DigitalInput scissorDownLimitSwitch;
	
	
	//Potentiometer
	AnalogInput ai;
	public static Potentiometer potentiometer;
	
	//Encoder stuff
	public static Encoder leftEncoder;
	public static Encoder rightEncoder;
	DigitalInput leftEncoderOne,leftEncoderTwo;
	DigitalInput rightEncoderOne,rightEncoderTwo;
	public static int currentPosLeft, currentPosRight;//stores each arm's current position. 
	//We need to manually turn the arms back before the match, or all will be thrown off
	public static boolean rightEncoderDirection,leftEncoderDirection;//stores the 
	//encoders' current direction to let the program know whether to add or subtract the 
	//raw encoder value
	
	
	SendableChooser chooser;

	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		
		Log.init("Robot initializing operator interface...");
		oi = new OI();
		Log.init("Operator interface initialized!");
		
		
		
		Log.init("Robot initializing subsystems...");
		
		tilterLimitSwitch = new DigitalInput(Config.TILTER_LIMIT_SWITCH);
		Log.init("TilterLimitSwitch initialized!");
		
		mySonic=new Ultrasonic(new DigitalOutput(Config.SONIC_PORT_TRIG),new DigitalInput(Config.SONIC_PORT_ECHO));
		
		Log.init("Ultrasonic initialized!");
		
		motorPWM_RearRight = new SteelTalon(Config.REAR_RIGHT_MOTOR);
		motorPWM_FrontRight = new SteelTalon(Config.FRONT_RIGHT_MOTOR);
		motorPWM_RearLeft = new SteelTalon(Config.REAR_LEFT_MOTOR);
		motorPWM_FrontLeft = new SteelTalon(Config.FRONT_LEFT_MOTOR);
		driveTrain = new DriveTrain(motorPWM_FrontLeft, motorPWM_RearLeft, motorPWM_FrontRight, motorPWM_RearRight);
		Log.init("driveTrain initialized!");

		motorRelay_Intake=new Relay(Config.INTAKE_MOTOR, Relay.Direction.kReverse);
		intake=new Intake(motorRelay_Intake);
		Log.init("Intaker initialized");
		
		
		motorRelay_RotateTurret = new Relay(Config.TURN_TURRET_MOTOR);
		motorRelay_TiltTurret = new Relay(Config.TILT_TURRET_MOTOR);
		motorPWM_Flywheel = new SteelTalon(Config.SHOOTER_MOTOR);
		launcher= new Launcher(motorPWM_Flywheel, motorRelay_RotateTurret, motorRelay_TiltTurret);
		Log.init("launcher initialized!");
		
		motorPWM_WinchOne = new SteelTalon(Config.WINCH_ONE_MOTOR);
		motorPWM_WinchTwo = new SteelTalon(Config.WINCH_TWO_MOTOR);
		winch = new Winch(motorPWM_WinchOne,motorPWM_WinchTwo);
		Log.init("winch initialized!");
		
		motorPWM_LeftArm = new SteelTalon(Config.LEFT_ARM_MOTOR);
		motorPWM_RightArm = new SteelTalon(Config.RIGHT_ARM_MOTOR);
		doorOpener = new DoorOpener(motorPWM_LeftArm, motorPWM_RightArm);
		
		Log.init("DoorOpener initialized!");

		motorRelay_ScissorLift =new Relay(Config.SCISSOR_MOTOR);
		scissorUpLimitSwitch=new DigitalInput(Config.SCISSOR_LIMIT_UP);
		scissorDownLimitSwitch= new DigitalInput(Config.SCISSOR_LIMIT_DOWN);
		scissorLift=new ScissorLift(motorRelay_ScissorLift, scissorUpLimitSwitch, scissorDownLimitSwitch );
		Log.init("scissorLift initialized!");

		//Log.init("Resetting Potentiometer...");
		//resetPotentiometer();
		Log.init("Potentiometer ready");
		
		//
		leftEncoderOne=new DigitalInput(Config.LEFT_ENCODER_PORT_ONE);
		leftEncoderTwo=new DigitalInput(Config.LEFT_ENCODER_PORT_TWO);
		rightEncoderOne=new DigitalInput(Config.RIGHT_ENCODER_PORT_ONE);
		rightEncoderOne=new DigitalInput(Config.RIGHT_ENCODER_PORT_TWO);
		leftEncoder=new Encoder(leftEncoderOne,leftEncoderTwo);
		rightEncoder=new Encoder(rightEncoderOne,rightEncoderTwo);
		leftEncoderDirection=leftEncoder.getDirection();
		rightEncoderDirection=rightEncoder.getDirection();
		new ResetEncoders();
		Log.init("Encoders ready and reset");
		
		Log.init("All subsystems ready!");
		
		Log.init("Loading interface...");
		chooser = new SendableChooser();

		SmartDashboard.putData("Auto mode", chooser);
		Log.init("Interface loaded!...");

		Log.init("All systems ready!");
		
		Log.init("Resetting Tilt to up");
		new resetTiltUp();
		// chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	public void autonomousInit() {
		Log.info("Autonomous Start!~");
		
		turnDegrees = 0;
		tiltDegrees = 0;

		Command autonomousCommand = null;
//		autonomousCommand = (Command) chooser.getSelected();

		//AutoLocateGoal autoLocateGoal = new AutoLocateGoal();
		//autoLocateGoal.start();
		// autonomousCommand = (Command) chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example) 
		 if (autonomousCommand != null)
			 autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		Log.info("Teleop Start!~");
		drive = new Drive();
		drive.start();
		
		mySonic.setEnabled(true);
		mySonic.setAutomaticMode(true);
		sonicDist=new SonicDist();
		
		
		
		//if(oi.getJoy().getX()!=0)
	
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		// if (autonomousCommand != null) autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	public static double getDistance()
	{return distanceInInches;}
	
	public void resetPotentiometer()
	{
		ai=new AnalogInput(Config.POTENTIOMETER_ANALOG_INPUT);
		potentiometer=new AnalogPotentiometer(ai,Config.POTENTIOMETER_SCALE,Config.POTENTIOMETER_OFFSET);
	}
	
	//returns the Ultrasonic sensor
	
}
