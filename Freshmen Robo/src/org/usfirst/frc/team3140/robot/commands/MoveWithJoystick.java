package org.usfirst.frc.team3140.robot.commands;

import org.usfirst.frc.team3140.robot.HardwareAdapter;
import org.usfirst.frc.team3140.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveWithJoystick extends Command implements HardwareAdapter {

	public MoveWithJoystick() {
		requires(Robot.el);
	}

	protected void execute() {
		Robot.el.move(xbox.getSmoothedMainY());
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

}
