package org.usfirst.frc.team3140.robot.commands;

import org.usfirst.frc.team3140.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinOff extends Command {

    public SpinOff() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.in);
    	System.out.println("spin off constructor reee");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.in.spinOff();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
