package org.usfirst.frc.team3140.robot.commands;

import org.usfirst.frc.team3140.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveUp extends Command {

    public MoveUp() {
    	requires(Robot.el);

    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    protected void execute() {
		Robot.el.moveUp();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}


    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    

    // Make this return true when this Command no longer needs to run execute()
    

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
