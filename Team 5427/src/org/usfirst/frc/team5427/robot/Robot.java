
package org.usfirst.frc.team5427.robot;

import org.usfirst.frc.team5427.robot.commands.AutoLaunchBoulder;
import org.usfirst.frc.team5427.robot.commands.AutoLocateGoal;
import org.usfirst.frc.team5427.robot.commands.Drive;
import org.usfirst.frc.team5427.robot.commands.GetStuffIn;
import org.usfirst.frc.team5427.robot.commands.SonicDist;
import org.usfirst.frc.team5427.robot.commands.UserControlledTurn;
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

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Scheduler;
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
 	static SpeedController MOTOR_PWM_FrontLeft;
 	
 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * Motor utilized in the DriveTrain. It is located in the rear left of the
 	 * robot from a top-down point of view, and setting the speed of this motor
 	 * to a positive value will cause the robot to move __________
 	 */
 	static SpeedController MOTOR_PWM_RearLeft;
 	
 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * Motor utilized in the DriveTrain. It is located in the front right of the
 	 * robot from a top-down point of view, and setting the speed of this motor
 	 * to a positive value will cause the robot to move __________
 	 */
 	static SpeedController MOTOR_PWM_FrontRight;
 	
 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * Motor utilized in the DriveTrain. It is located in the rear right of the
 	 * robot from a top-down point of view, and setting the speed of this motor
 	 * to a positive value will cause the robot to move __________
 	 */
 	static SpeedController MOTOR_PWM_RearRight;
 	
 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * Motor that powers the FlyWheel which is responsible for launching the
 	 * boulder from the robot on contact. Setting it to a positive speed will
 	 * make it make the wheel spin __________ relative to the front of the
 	 * shooting mechanism.
 	 */
 	static SpeedController MOTOR_PWM_Flywheel;

 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * Motor that controls the movement of the left arm on the robot, moving it
 	 * either forwards or backwards. Setting its speed to a positive value will
 	 * cause the arm to move _________
 	 */
 	static SpeedController MOTOR_PWM_LeftArm;
 	
 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * Motor that controls the movement of the right arm on the robot, moving it
 	 * either forwards or backwards. Setting its speed to a positive value will
 	 * cause the arm to move _________
 	 */
 	static SpeedController MOTOR_PWM_RightArm;

 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * One of the two motors that is responsible for controlling the winch on
 	 * the robot. This is the motor that is located closer to the front of the
 	 * robot, and setting its speed to 1 will cause the spool of wire to
 	 * _________
 	 */
 	static SpeedController MOTOR_PWM_WinchOne;
 	
 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * One of the two motors that is responsible for controlling the winch on
 	 * the robot. This is the motor that is located closer to the front of the
 	 * robot, and setting its speed to 1 will cause the spool of wire to
 	 * _________
 	 */
 	static SpeedController MOTOR_PWM_WinchTwo;

 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * A small motor that is attached to the front of the shooting mechanism and
 	 * is meant to turn a set of wheels that will intake the ball. Setting this
 	 * to forwards will make the intake __________ incoming boulders.
 	 */
 	static Relay MOTOR_RELAY_Intake;
 	
 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * A small motor that is meant to rotate the turret. Setting the motor to
 	 * forwards will make the turret turn ________
 	 */
 	static Relay MOTOR_RELAY_RotateTurret;
 	
 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * A small motor that is meant to tilt the turret. Setting it to forwards
 	 * will make the turret tilt _________
 	 */
 	static Relay MOTOR_RELAY_TiltTurret;
 	
 	// TODO fill in the blank in this comment after testing the robot.
 	/**
 	 * A small motor that is mean to extend/retract the scissor lift at the back
 	 * of the robot. Setting the direction to forwards will cause the scissor
 	 * lift to move ___________
 	 */
 	static Relay MOTOR_RELAY_ScissorLift;


	Thread ultrasonicThread;
	
	 Drive drive;
	 SonicDist sonicDist;
	 //new intake system
	 //public static GetStuffIn getStuff;
	 //stores distance in inches from the object
	 public static double distanceInInches;
	 
	//UserControlledTurn turn;
	AutoLaunchBoulder autoLaunchBoulder;

	static Relay turner;
	
	static SpeedController winchLeft;
	static SpeedController winchRight;

	static SpeedController intakeLeft;
	static SpeedController intakeRight;
	
	static Relay scissor;
	
	static Relay getBoulderIn;
	
	public static DriveTrain driveTrain;
	public static Launcher launcher;
	public static Winch winch;
	public static ScissorLift scissorLift;
	public static OI oi;
	public static SteelUltrasonic steelUltrasonic;
	public static Intake intake;
	public static DoorOpener doorOpener;
	
	public static Ultrasonic mySonic;
	
	double turnDegrees;
	double tiltDegrees;
	
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
		
		
		mySonic=new Ultrasonic(new DigitalOutput(Config.SONIC_PORT_TRIG),new DigitalInput(Config.SONIC_PORT_ECHO));
		
		Log.init("Ultrasonic initialized!");
		
		MOTOR_PWM_RearRight = new SteelTalon(Config.BACK_RIGHT_MOTOR);
		MOTOR_PWM_FrontRight = new SteelTalon(Config.FRONT_RIGHT_MOTOR);
		MOTOR_PWM_RearLeft = new SteelTalon(Config.BACK_LEFT_MOTOR);
		MOTOR_PWM_FrontLeft = new SteelTalon(Config.FRONT_LEFT_MOTOR);
		driveTrain = new DriveTrain(MOTOR_PWM_FrontLeft, MOTOR_PWM_RearLeft, MOTOR_PWM_FrontRight, MOTOR_PWM_RearRight);
		Log.init("driveTrain initialized!");

//		getBoulderIn=new Relay(Config.RELAY_PORT, Relay.Direction.kReverse);
//		intake=new Intake(getBoulderIn);
//		Log.init("Intaker initialized");
//		
//		
//		turner = new Relay(Config.TURNER_MOTOR);
//		tilter = new SteelTalon(Config.TILTER_MOTOR);
//		shooter = new SteelTalon(Config.SHOOTER_MOTOR);
//		launcher= new Launcher(shooter, turner, tilter);
//		Log.init("launcher initialized!");
//		
//		winchLeft = new SteelTalon(Config.WINCH_LEFT_MOTOR);
//		winchRight = new SteelTalon(Config.WINCH_RIGHT_MOTOR);
//		winch = new Winch(winchLeft,winchRight);
//		Log.init("winch initialized!");
		
		MOTOR_PWM_LeftArm = new SteelTalon(Config.LEFT_ARM_MOTOR);
		MOTOR_PWM_RightArm = new SteelTalon(Config.RIGHT_ARM_MOTOR);
		doorOpener = new DoorOpener(MOTOR_PWM_LeftArm, MOTOR_PWM_RightArm);
		Log.init("winch initialized!");
//
//
//		scissor=new Relay(Config.SCISSOR_MOTOR);
//
//		scissorLift=new ScissorLift(scissor);
//		Log.init("scissorLift initialized!");

		
		Log.init("All subsystems ready!");
		
		Log.init("Loading interface...");
		chooser = new SendableChooser();

		SmartDashboard.putData("Auto mode", chooser);
		Log.init("Interface loaded!...");

		Log.init("All systems ready!");
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
		// if (autonomousCommand != null) autonomousCommand.start();
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
	
	
	
	//returns the Ultrasonic sensor
	
}
