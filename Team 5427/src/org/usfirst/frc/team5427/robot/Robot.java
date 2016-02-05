
package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team5427.robot.commands.AutoLaunchBoulder;
import org.usfirst.frc.team5427.robot.commands.AutoLocateGoal;
import org.usfirst.frc.team5427.robot.commands.Drive;
import org.usfirst.frc.team5427.robot.commands.Turn;
import org.usfirst.frc.team5427.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5427.robot.subsystems.Intake;
import org.usfirst.frc.team5427.robot.subsystems.Launcher;
import org.usfirst.frc.team5427.robot.util.Config;
import org.usfirst.frc.team5427.robot.util.Log;

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

	Drive drive;
	Turn turn;
	AutoLaunchBoulder autoLaunchBoulder;
	
	static SpeedController frontLeft;
	static SpeedController backLeft;
	static SpeedController frontRight;
	static SpeedController backRight;
	
	static SpeedController shooter;
	static SpeedController tilter;
	static SpeedController turner;

	static SpeedController intakeLeft;
	static SpeedController intakeRight;
	
	public static DriveTrain driveTrain;
	public static Intake intake;
	public static Launcher launcher;
	public static OI oi;

	// Command autonomousCommand; TODO delete this line upon completion
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
		
		backRight = new SteelTalon(Config.BACK_RIGHT_MOTOR);
		frontRight = new SteelTalon(Config.FRONT_RIGHT_MOTOR);
		backLeft = new SteelTalon(Config.BACK_LEFT_MOTOR);
		frontLeft = new SteelTalon(Config.FRONT_LEFT_MOTOR);
		driveTrain = new DriveTrain(frontLeft, backLeft, frontRight, backRight);
		Log.init("driveTrain initialized!");
		intake = new Intake(intakeLeft, intakeRight);
		Log.init("intake initialized!");
		
		turner = new SteelTalon(Config.TURNER_MOTOR);
		tilter = new SteelTalon(Config.TILTER_MOTOR);
		shooter = new SteelTalon(Config.SHOOTER_MOTOR);
		launcher= new Launcher(shooter, turner, tilter);
		Log.init("launcher initialized!");
		
		Log.init("All subsystems ready!");
		
		Log.init("Loading interface...");
		chooser = new SendableChooser();
		// chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		Log.init("Interface loaded!...");

		Log.init("All systems ready!");
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
		AutoLocateGoal autoLocateGoal = new AutoLocateGoal();
		autoLocateGoal.start();
		// autonomousCommand = (Command) chooser.getSelected(); TODO delete this
		// line upon completion

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		// if (autonomousCommand != null) autonomousCommand.start(); TODO delete
		// this line upon completion
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
		
		turn=new Turn();
		turn.start();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		// if (autonomousCommand != null) autonomousCommand.cancel(); TODO
		// delete this line upon completion
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//if(oi.get)

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
