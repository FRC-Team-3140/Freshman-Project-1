package main.commands.autos;

import interfacesAndAbstracts.ImprovedCommandGroup;
import main.commands.drivetrain.TimedDrive;

public class Baseline extends ImprovedCommandGroup {
	
	public Baseline() {
		addSequential(new TimedDrive(TIMED_DRIVE_THROTTLE, 144/DT_IN_PER_SEC));
	}

}
