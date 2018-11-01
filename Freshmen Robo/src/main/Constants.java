package main;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public interface Constants {
	
	public final double DT_IN_PER_SEC = 1; //TODO this
	public final double TIMED_DRIVE_THROTTLE = 0.9;
	public final double TIMED_TURN_THROTTLE = 0.75;
	public final double TIME_90_DEG = 1;
	
	/*************
	 * CONSTANTS *
	 *************/
	// PNEUMATIC STATES
	public final DoubleSolenoid.Value EXT = Value.kForward;
	public final DoubleSolenoid.Value RET = Value.kReverse;
	public final DoubleSolenoid.Value OFF = Value.kOff;
	
	// TALON CONTROL MODES
	public final ControlMode SLAVE_MODE = ControlMode.Follower;
	public final ControlMode PERCENT_VBUS_MODE = ControlMode.PercentOutput;
	public final NeutralMode BRAKE_MODE = NeutralMode.Brake;
	public final ControlMode POSITION_MODE = ControlMode.Position;
	
	public enum TurnMode {Right, Left}
	
	/*********
	 * PORTS *
	 *********/	
	public final int XBOX_PORT = 0;
	public static int Xbox2_Port = 1;

	// JOYSTICK DEADBAND'S
	public final double throttleDeadband = 0.1;
	public final double headingDeadband = 0.1;
	public final double strafeDeadband = 0.1;
	
	// DRIVETRAIN TALONS (CAN BUS)
	public final int LEFT_Drive_Master = 3;
	public final int LEFT_Drive_Slave1 = 6;
	public final int RIGHT_Drive_Master = 12;
	public final int RIGHT_Drive_Slave1 = 5;
	public final int LEFT_Drive_Slave2 = 9;
	public final int RIGHT_Drive_Slave2 = 4;
	
	// PNEUMATICS CONTROL MODULE
	public final int PCM_Port1 = 1;
	
	// INTAKE PNEUMATICS
	public final int INTAKE_EXT = 7;
	public final int INTAKE_RET = 0;
	public final int TILT_EXT = 6;
	public final int TILT_RET = 1;
	
	// SHIFTING
	public final int SHIFTER_EXT = 5;
	public final int SHIFTER_RET = 2;
	
	// INTAKE MOTORS	
	public final int LEFT_Intake = 1;
	public final int RIGHT_Intake = 0;
}
