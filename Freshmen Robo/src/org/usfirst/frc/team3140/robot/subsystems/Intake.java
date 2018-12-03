/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3140.robot.subsystems;

import org.usfirst.frc.team3140.robot.Constants;
import org.usfirst.frc.team3140.robot.HardwareAdapter;
import org.usfirst.frc.team3140.robot.commands.SpinWithJoystick;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem implements Constants, HardwareAdapter {
	
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
	public void oof(double throttle) {
		leftIntakeMotor.set(throttle);
		rightIntakeMotor.set(-throttle);
	}
	
	
	//hooray
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new SpinWithJoystick());

	}
}
