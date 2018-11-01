package main.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.DriverStation;
import util.ChezyMath;
import util.DriveHelper;
import util.EncoderHelper;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import interfacesAndAbstracts.ImprovedSubsystem;
import main.Robot;
import main.commands.drivetrain.Drive;


public class Drivetrain extends ImprovedSubsystem {
	//TELEOP DRIVING
	private DriveHelper driveHelper = new DriveHelper(7.5);


	public Drivetrain() {
		setTalonDefaults();
	}
	/*****************
	 * DRIVE METHODS *
	 *****************/
	
	// DRIVE FOR TELEOP
	public void driveVelocity(double throttle, double heading) {
		arcadeDrive(driveHelper.handleOverPower(driveHelper.handleDeadband(-throttle, throttleDeadband)),
				driveHelper.handleOverPower(driveHelper.handleDeadband(-heading, headingDeadband)), true);
	
	}
	
	public void timedTurn(TurnMode mode, double throttle) {
		if (mode == TurnMode.Left) tankDrive(-throttle, throttle, false);
		if (mode == TurnMode.Right) tankDrive(throttle, -throttle, false);
	}
	
	// SIMPLE ARCADE DRIVE
	public void arcadeDrive(double throttle, double heading, boolean squared) {
		if(squared) {
			throttle = Math.signum(throttle) * throttle * throttle;
			heading = Math.signum(heading) * heading * heading;
		}
		tankDrive(throttle + heading, throttle - heading, false);
	}
		
	// SIMPLE TANK DRIVE
	public void tankDrive(double left, double right, boolean squaredInput) {
		leftDriveMaster.set(left);
		rightDriveMaster.set(right);
	}
	
	/*******************
	 * VOLTAGE METHODS *
	 *******************/
	public double getLeftMasterVoltage() {
		return (leftDriveMaster.getMotorOutputVoltage());
	}
	
	public double getRightMasterVoltage() {
		return (rightDriveMaster.getMotorOutputVoltage());
	}
	
	public double getLeftSlaveVoltage() {
		return (leftDriveSlave1.getMotorOutputVoltage());
	}
	
	public double getRightSlaveVoltage() {
		return (rightDriveSlave1.getMotorOutputVoltage());
	}
	
	/*************************
	 * DRIVE SUPPORT METHODS *
	 *************************/
	private void reverseTalons(boolean isInverted) {
		leftDriveMaster.setInverted(isInverted);
		rightDriveMaster.setInverted(isInverted);
		leftDriveSlave1.setInverted(isInverted);
		rightDriveSlave1.setInverted(isInverted);
	}

	private void setBrakeMode(NeutralMode mode) {
		leftDriveMaster.setNeutralMode(mode);
		leftDriveSlave1.setNeutralMode(mode);
		rightDriveMaster.setNeutralMode(mode);
		rightDriveSlave1.setNeutralMode(mode);
	}

	private void setCtrlMode() {
		leftDriveSlave1.follow(leftDriveMaster);
		rightDriveSlave1.follow(rightDriveMaster);
	}

	public void setTalonDefaults() {
		reverseTalons(false);
		setBrakeMode(BRAKE_MODE);
		setCtrlMode();
		rightDriveMaster.setInverted(true);
		rightDriveSlave1.setInverted(true); //TODO move this somewhere else pls
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}

	@Override
	public void check() {
	}
	@Override
	public void zeroSensors() {
		// TODO Auto-generated method stub
		
	}
}
