package org.usfirst.frc.team6956.robot.commands;

import org.usfirst.frc.team6956.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {
	
	double desiredDistance;
	
    public DriveDistance(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	desiredDistance = distance;
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetDistanceTravelled();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.setTankDrive(0.5, 0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if ( Robot.drivetrain.getDistanceTravelled() > desiredDistance) {
        	return true;
        } else { 
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.setTankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
