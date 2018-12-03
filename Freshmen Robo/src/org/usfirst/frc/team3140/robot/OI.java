/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3140.robot;
import org.usfirst.frc.team3140.robot.commands.MoveUp;
import org.usfirst.frc.team3140.robot.commands.SpinIn;
import org.usfirst.frc.team3140.robot.commands.SpinOff;
import org.usfirst.frc.team3140.robot.commands.SpinOut;
import org.usfirst.frc.team3140.robot.commands.StopMoving;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements HardwareAdapter, Constants {
	
	public OI() {
		System.out.println("OI constructor");
		xbox.b.whileHeld(new SpinOut());
		xbox.a.whileHeld(new SpinIn());
		xbox.b.whenReleased(new SpinOff());
		xbox.a.whenReleased(new SpinOff());
		
		xbox.y.whenPressed(new MoveUp());
		xbox.y.whenReleased(new StopMoving());

	}
	
	public void check() {
		xbox.check();
	}
}
