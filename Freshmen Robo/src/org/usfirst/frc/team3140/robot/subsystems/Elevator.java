package org.usfirst.frc.team3140.robot.subsystems;

import org.usfirst.frc.team3140.robot.Constants;
import org.usfirst.frc.team3140.robot.HardwareAdapter;
import org.usfirst.frc.team3140.robot.commands.MoveWithJoystick;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem implements HardwareAdapter, Constants {
	
	public Elevator() {
		elevator2.follow(elevator1);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MoveWithJoystick());
	}
	public void moveUp() {
		elevator1.set(-.5);
	}

	public void stopMoving() {
		elevator1.set(0);
	}

	public void moveDown() {
		elevator1.set(0.5);
		
	}
	
	public void move(double throttle) {
		elevator1.set(throttle);
	}
}
