/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package main;
import lib.joystick.XboxController;
import main.commands.drivetrain.TimedDrive;
import main.commands.drivetrain.TimedTurn;
import main.commands.intake.SpinIn;
import main.commands.intake.SpinOff;
import main.commands.intake.SpinOut;
import main.commands.pneumatics.arm.ArmClose;
import main.commands.pneumatics.arm.ArmOpen;
import main.commands.pneumatics.arm.SwitchArm;
import main.commands.pneumatics.shift.ShiftDown;
import main.commands.pneumatics.shift.ShiftUp;
import main.commands.pneumatics.tilt.SwitchTilt;
import main.commands.pneumatics.tilt.TiltDown;
import main.commands.pneumatics.tilt.TiltUp;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements HardwareAdapter, Constants {
	
	public OI() {
		xbox.leftJoystickPress.whenPressed(new ShiftUp());
		xbox.leftJoystickPress.whenReleased(new ShiftDown());

		xbox2.leftBumper.whenPressed(new SwitchTilt(new TiltDown(), new TiltUp()));
		xbox2.rightBumper.whenPressed(new SwitchArm(new ArmOpen(), new ArmClose()));
		
		xbox.a.whenPressed(new TimedDrive(TIMED_DRIVE_THROTTLE, 2));
		xbox.b.whenPressed(new TimedTurn(TurnMode.Left, TIMED_TURN_THROTTLE, 2));
		xbox.x.whenPressed(new TimedTurn(TurnMode.Left, TIMED_TURN_THROTTLE, 3));

		
	}
	
	public void check() {
		xbox.check();
	}
	
	public static XboxController getXbox() {
		return xbox;
	}
	
	public static XboxController getXbox2() {
		return xbox2;
	}
	
}
