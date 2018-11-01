package main.commands.autos;

import edu.wpi.first.wpilibj.command.WaitCommand;
import interfacesAndAbstracts.ImprovedCommandGroup;
import main.Constants.TurnMode;
import main.commands.drivetrain.TimedDrive;
import main.commands.drivetrain.TimedTurn;
import main.commands.intake.SpinOff;
import main.commands.intake.SpinOut;

public class CenterToRightSwitch extends ImprovedCommandGroup{
	
	public CenterToRightSwitch() {
		addSequential(new TimedDrive(TIMED_DRIVE_THROTTLE, 50/DT_IN_PER_SEC));
		addSequential(new TimedTurn(TurnMode.Right, TIMED_TURN_THROTTLE, TIME_90_DEG));
		addSequential(new TimedDrive(TIMED_DRIVE_THROTTLE, 60/DT_IN_PER_SEC));
		addSequential(new TimedTurn(TurnMode.Left, TIMED_TURN_THROTTLE, TIME_90_DEG));
		addSequential(new TimedDrive(TIMED_DRIVE_THROTTLE, 80/DT_IN_PER_SEC));
		addSequential(new SpinOut());
		addSequential(new WaitCommand(3));
		addSequential(new SpinOff());
	}

}
