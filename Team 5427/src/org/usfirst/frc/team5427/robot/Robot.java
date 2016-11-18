
package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5427.robot.commands.auto.autonomous.Lowbar;
import org.usfirst.frc.team5427.robot.commands.auto.autonomous.Moat;
import org.usfirst.frc.team5427.robot.commands.auto.autonomous.Ramparts;
import org.usfirst.frc.team5427.robot.commands.auto.autonomous.Rockwall;
import org.usfirst.frc.team5427.robot.commands.auto.autonomous.RoughTerrain;
import org.usfirst.frc.team5427.robot.commands.subsystemControl.*;
import org.usfirst.frc.team5427.robot.network.Client;
import org.usfirst.frc.team5427.robot.subsystems.Intake;
import org.usfirst.frc.team5427.robot.subsystems.LeftArm;
import org.usfirst.frc.team5427.robot.subsystems.RightArm;
import org.usfirst.frc.team5427.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5427.robot.subsystems.Launcher;
import org.usfirst.frc.team5427.robot.subsystems.ScissorLift;
import org.usfirst.frc.team5427.robot.subsystems.Winch;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;
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
@SuppressWarnings("unused")
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
	static SteelTalon motorPWM_RotateTurret;

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

	Drive drive;

	POVModifier POVModifier;

	public Client c;

	// new intake system
	// public static GetStuffIn getStuff;

	// UserControlledTurn turn;

	public static Launcher launcher;
	public static Winch winch;
	public static ScissorLift scissorLift;
	public static OI oi;
	public static Intake intake;

	public static DriveTrain driveTrain;
	public static LeftArm leftArm;
	public static RightArm rightArm;

	double turnDegrees;
	double tiltDegrees;

	// Limit switches
	public static DigitalInput tilterLimitSwitch;
	public static DigitalInput scissorUpLimitSwitch;
	public static DigitalInput scissorDownLimitSwitch;

	// Potentiometer
	public static AnalogInput ai;
	public static Potentiometer potentiometer;
	// Arm pot stuff
	public static Potentiometer leftArmPot;
	public static Potentiometer rightArmPot;
	public static AnalogInput leftPotPort, rightPotPort;

	SendableChooser chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {

		Log.init("Operator interface initialized!");

		try {
			Log.init("Initializing connection to the driver station...");
			c = new Client();
			c.start();
			if (c.isConnected())
				Log.init("Connection successfully established with the driver station.");
			else
				Log.init("Connection failed to establish. Client will continue to connect with the driver station.");
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		Log.init("Robot initializing subsystems...");

		tilterLimitSwitch = new DigitalInput(Config.TILTER_LIMIT_SWITCH);
		Log.init("TilterLimitSwitch initialized!");

		motorPWM_RearRight = new SteelTalon(Config.REAR_RIGHT_MOTOR, 0, 0);
		motorPWM_FrontRight = new SteelTalon(Config.FRONT_RIGHT_MOTOR, 0, 0);
		motorPWM_RearLeft = new SteelTalon(Config.REAR_LEFT_MOTOR, 0, 0);
		motorPWM_FrontLeft = new SteelTalon(Config.FRONT_LEFT_MOTOR, 0, 0);
		driveTrain = new DriveTrain(motorPWM_FrontLeft, motorPWM_RearLeft, motorPWM_FrontRight, motorPWM_RearRight);
		Log.init("driveTrain initialized!");

		motorRelay_Intake = new Relay(Config.INTAKE_MOTOR, Relay.Direction.kReverse);
		intake = new Intake(motorRelay_Intake);
		Log.init("Intaker initialized");

		motorPWM_RotateTurret = new SteelTalon(Config.TURRET_MOTOR);
		motorRelay_TiltTurret = new Relay(Config.TILT_TURRET_MOTOR);
		motorPWM_Flywheel = new SteelTalon(Config.SHOOTER_MOTOR);
		launcher = new Launcher(motorPWM_Flywheel, motorPWM_RotateTurret, motorRelay_TiltTurret);
		Log.init("launcher initialized!");

//		motorPWM_WinchOne = new SteelTalon(Config.WINCH_ONE_MOTOR);
//		motorPWM_WinchTwo = new SteelTalon(Config.WINCH_TWO_MOTOR);
//		winch = new Winch(motorPWM_WinchOne, motorPWM_WinchTwo);
//		Log.init("winch initialized!");

		motorPWM_LeftArm = new SteelTalon(Config.LEFT_ARM_MOTOR);
		motorPWM_RightArm = new SteelTalon(Config.RIGHT_ARM_MOTOR);
		leftArm = new LeftArm(motorPWM_LeftArm);
		rightArm = new RightArm(motorPWM_RightArm);
		Log.init("Arms initialized!");

//		motorRelay_ScissorLift = new Relay(Config.SCISSOR_MOTOR);
//		scissorUpLimitSwitch = new DigitalInput(Config.SCISSOR_LIMIT_UP);
//		scissorDownLimitSwitch = new DigitalInput(Config.SCISSOR_LIMIT_DOWN);
//		scissorLift = new ScissorLift(motorRelay_ScissorLift, scissorUpLimitSwitch, scissorDownLimitSwitch);
//		Log.init("scissorLift initialized!");

		Log.init("Resetting Potentiometers...");
		resetPotentiometers();
		Log.init("Potentiometers ready");

		Log.init("All subsystems ready!");

		Log.init("Loading interface...");
		chooser = new SendableChooser();

		SmartDashboard.putData("Auto mode", chooser);
		Log.init("Interface loaded!...");

		// Log.init("Robot initializing SmartDashboard...");
		// new SmartDashboardStuff();

		Log.init("Robot initializing operator interface...");
		oi = new OI();

		Log.init("All systems ready!");

		// ***Log.init("Resetting Tilt to up");
		// ***new resetTiltUp();
		// Uncomment the above after Tilt has been tested

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
	@SuppressWarnings("unused")
	public void autonomousInit() {
		Log.info("Autonomous Start!~");

		// if (Client.isConnected())
		// Client.send(StringDictionary.AUTO_START);

		turnDegrees = 0;
		tiltDegrees = 0;

		// ^^^Change variables for specific Autonomous
		double distance = 1, turnDegrees = 90;
		boolean forward = true, right = true, forwardObs = true;

		Command autonomousCommand = null;

		// RoughTerrain r = new RoughTerrain();
		// r.start();
		// new RoughTerrain().start();

		// ((Command) oi.autoChooser.getSelected()).start();

		switch ((Integer) oi.autoChooser.getSelected()) {
		case 1:
			new Moat().start();
			break;
		case 2:
			new RoughTerrain().start();
			break;
		case 3:
			new Rockwall().start();
			break;
		case 4:
			new Ramparts().start();
			break;
		case 5:
			new Lowbar().start();
			break;
		case 6:

			break;
		default:
			break;

		}

	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {

		Log.info("Teleop Start!~");
		
		//SmartDashboard.putData("Test", new Test());
		
		// if (Client.isConnected())
		// Client.send(StringDictionary.TELEOP_START);

		drive = new Drive();
		drive.start();

		POVModifier = new POVModifier();
		POVModifier.start();

		// if(oi.getJoy().getX()!=0)

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

		SmartDashboard.putNumber("Turret Potentiometer Value:", ai.getValue());
	//	SmartDashboard.putNumber("Turret Degree value:", Robot.launcher.getDegrees());
		SmartDashboard.putNumber("Left Arm Potentiometer Value:", Robot.leftArmPot.get());
		SmartDashboard.putNumber("Right Arm Potentiometer Value:", Robot.rightArmPot.get());
		
		/*
		if((Integer)(oi.test.getSelected()) == 1){
			new Shoot();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new IntakeIn();
		}
		*/// Log.info(Robot.oi.getJoy().getPOV(0) + "");
		// Log.info(tilterLimitSwitch.get() + "");
		// Log.info(potentiometer.get() + "");
		// Log.info(launcher.getDegrees()+"");
		// Log.info("LEFT ARM " + leftArmPot.get() + "");
		// Log.info(launcher.getDegrees()+"");
		// Log.info("RIGHT ARM "+ rightArmPot.get()+"");
		// Log.info("limit switch "+tilterLimitSwitch.get() + "\n");
		try {
			// Thread.sleep(150);

		} catch (Exception e) {

		}
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}

	public static void resetPotentiometers() {
		ai = new AnalogInput(Config.POTENTIOMETER_ANALOG_INPUT);
		potentiometer = new AnalogPotentiometer(ai);
		//or maybe this is better new AnalogPotentiometer(ai, Config.TURRET_POTENTIOMETER_SCALE, Config.TURRET_POTENTIOMETER_OFFSET);
		leftPotPort = new AnalogInput(Config.LEFT_POT_PORT);
		leftArmPot = new AnalogPotentiometer(leftPotPort, Config.LEFT_POT_SCALE, Config.LEFT_POT_OFFSET);
		rightPotPort = new AnalogInput(Config.RIGHT_POT_PORT);
		rightArmPot = new AnalogPotentiometer(rightPotPort, Config.RIGHT_POT_SCALE, Config.RIGHT_POT_OFFSET);

	}

	public double returnDouble(int i) {
		return i + 0f;
	}
}
