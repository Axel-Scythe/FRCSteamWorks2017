package org.frc1793.robot.commands.firing;

import org.frc1793.robot.components.Shooter;
import org.strongback.command.Command;
import org.strongback.components.ui.ContinuousRange;

/**
 *
 *
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/15/2017
 */
@SuppressWarnings("ALL")
public class SingleFireCommand extends Command {

    private Shooter shooter;
    private final ContinuousRange speed;

    /**
     * Create a firing comm*and
     * @param drive the launching mechanism
     * @param speed the speed at which to shooter the shooter; always positive
     * @param duration the duration of this command; should be positive
     *
     */
    public SingleFireCommand(Shooter drive, ContinuousRange speed, double duration) {
        super(duration,drive);
        this.shooter = drive;
        this.speed = speed;
    }

    @Override
    public boolean execute() {
        shooter.shooter(speed.read());
        return false;
    }

    @Override
    public void interrupted() {
        shooter.stop();
    }

    @Override
    public void end() {
        shooter.stop();
    }
}