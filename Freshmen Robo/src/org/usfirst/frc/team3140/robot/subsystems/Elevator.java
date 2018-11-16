package org.usfirst.frc.team3140.robot.subsystems;

import org.usfirst.frc.team3140.robot.Constants;
import org.usfirst.frc.team3140.robot.HardwareAdapter;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem implements HardwareAdapter, Constants {

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	public void moveUp() {
		elevator1.set(0.5);
	}

	public void stopMoving() {
		elevator1.set(0);
	}

	public void moveDown() {
		elevator1.set(-0.5);
		
	}
}
