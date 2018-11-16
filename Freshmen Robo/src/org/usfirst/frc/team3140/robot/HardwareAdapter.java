package org.usfirst.frc.team3140.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Spark;
import lib.joystick.XboxController;

public interface HardwareAdapter extends Constants {
	
	public static XboxController xbox = new XboxController(XBOX_PORT);
	
	public static Spark leftIntakeMotor = new Spark(LEFT_Intake);
	public static Spark rightIntakeMotor = new Spark(RIGHT_Intake);
	public static WPI_TalonSRX elevator1 = new WPI_TalonSRX(ELEVATOR_1);


}