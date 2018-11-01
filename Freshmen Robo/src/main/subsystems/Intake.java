/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package main.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import main.Constants;
import main.HardwareAdapter;
import util.DriveHelper;

public class Intake extends Subsystem implements Constants, HardwareAdapter {
	private DriveHelper driveHelper = new DriveHelper(7.5);
	
	double intakeDeadband = 0.1;
	
	public void spinIn() {
		leftIntakeMotor.set(1.0);
		rightIntakeMotor.set(-1.0);
	}

	public void spinOut() {
		leftIntakeMotor.set(-1.0);
		rightIntakeMotor.set(1.0);
	}
	
	public void spinOff() {
		leftIntakeMotor.set(0);
		rightIntakeMotor.set(0);
	}
	//hooray
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(null);

	}
	
	public void moveWithJoystick(double throttle) {
		leftIntakeMotor.set(driveHelper.handleOverPower(driveHelper.handleDeadband(throttle, intakeDeadband)));
		rightIntakeMotor.set(-driveHelper.handleOverPower(driveHelper.handleDeadband(throttle, intakeDeadband)));
	}
}
