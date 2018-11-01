/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package main;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.commands.autos.Baseline;
import main.commands.autos.CenterToLeftSwitch;
import main.commands.autos.CenterToRightSwitch;
import main.commands.autos.DoNothing;
import main.commands.autos.LeftToLeftSwitch;
import main.commands.autos.RightToRightSwitch;
import main.commands.intake.SpinOut;
import main.subsystems.Drivetrain;
import main.subsystems.Intake;
import main.subsystems.Pneumatics;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot implements HardwareAdapter, Constants {
	public static Intake in;
	public static Drivetrain dt;
	public static Pneumatics pn;
	public static OI oi;
	
	// AUTO LOGIC
	private enum StartPos {LEFT, CENTER, RIGHT}
	private enum RobotAction {DO_NOTHING, BASELINE, SWITCH}
	//private enum RobotAction{DO_Nothing, EDGECASE_DoNothing, EDGECASE_Baseline, EDGECASE_SwitchFromBehind}
	public static StartPos start_pos;
	public static RobotAction robot_act;
	private static SendableChooser<RobotAction> autoChooser;
	private static SendableChooser<StartPos> startPos;
	private static Command autoCommand;
	


	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		in = new Intake();
		dt = new Drivetrain();
		pn = new Pneumatics();
		// oi must come last
		oi = new OI();
		
		// Auto modes
		autoChooser = new SendableChooser<>();
		autoChooser.addDefault("Do Nothing", RobotAction.DO_NOTHING);
		autoChooser.addObject("Baseline", RobotAction.BASELINE);
		autoChooser.addObject("Switch Priority", RobotAction.SWITCH);
		// Starting Pos
		startPos = new SendableChooser<>();
		startPos.addDefault("Left", StartPos.LEFT);
		startPos.addObject("Center", StartPos.CENTER);
		startPos.addObject("Right", StartPos.RIGHT);
		SmartDashboard.putData("Starting Position", startPos);
		SmartDashboard.putData("Auto Mode", autoChooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		String gmsg = DriverStation.getInstance().getGameSpecificMessage();
		while (gmsg == null || gmsg.length() != 3) {
			gmsg = DriverStation.getInstance().getGameSpecificMessage();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("message" + gmsg);
		System.out.println("auto" + autoChooser.getSelected());
		System.out.println("pos" + startPos.getSelected());

		boolean leftSwitch = gmsg.charAt(0) == 'L';
			
		start_pos = startPos.getSelected();
		robot_act = autoChooser.getSelected();
		
		if(robot_act == RobotAction.DO_NOTHING)//Do Nothing
			autoCommand = new DoNothing();
		
		else if(robot_act == RobotAction.BASELINE)//Baseline
			autoCommand = new Baseline();
		
		else if(robot_act == RobotAction.SWITCH) {//Priority Switch
			if(start_pos == StartPos.LEFT) {
				if(leftSwitch) {
					autoCommand = new LeftToLeftSwitch();
				}
				else autoCommand = new Baseline();					
			}
			else if(start_pos == StartPos.CENTER) {
				if(leftSwitch) autoCommand = new CenterToLeftSwitch();
				else autoCommand = new CenterToRightSwitch();
			}
			else if(start_pos == StartPos.RIGHT) {
				if(!leftSwitch) {
					autoCommand = new RightToRightSwitch();
				}
				else autoCommand = new Baseline();					
			}
		}
		
		if(autoCommand != null) autoCommand.start();

	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		oi.check();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
