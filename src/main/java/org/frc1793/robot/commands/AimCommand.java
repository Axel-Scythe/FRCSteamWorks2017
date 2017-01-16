package org.frc1793.robot.commands;

import org.strongback.command.Command;
import org.strongback.components.AngleSensor;
import org.strongback.components.Motor;

/**
 * Created by melvin on 1/15/2017.
 */
public class AimCommand extends Command {

    public static final double HIGH_GOAL = 120;
    public static final double LOW_GOAL = 90;

    private double angle;
    private Motor motor;
    private AngleSensor angleSensor;


    /**
     *
     * @param angle number in degrees to set the launcher to aim at.
     * @param motor supplied motor controller to change to the necessary angle.
     * @param angleSensor sensor to supply the current position of motor
     */
    public AimCommand(double angle, Motor motor, AngleSensor angleSensor) {
        this.angle = angle;
        this.motor = motor;
        this.angleSensor = angleSensor;
    }
    @Override
    public boolean execute() {
        double dir = angleSensor.computeAngleChangeTo(angle,1);
        motor.setSpeed(dir > 0? 1 : -1);
        return false;
    }

    @Override
    public void interrupted() {
        motor.stop();
    }

    @Override
    public void end() {
        motor.stop();
    }
}