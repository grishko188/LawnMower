package com.grishko188.lawnmower.engine;

import com.grishko188.lawnmower.engine.models.Lawn;
import com.grishko188.lawnmower.engine.models.Mower;
import com.grishko188.lawnmower.engine.models.utils.Command;
import com.grishko188.lawnmower.engine.models.utils.CommandsProcessor;
import com.grishko188.lawnmower.engine.models.utils.Direction;
import com.grishko188.lawnmower.engine.models.utils.Point;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class LawnMowerController {

    private Lawn lawn;
    private Queue<Mower> mowers;

    public LawnMowerController(int lawnWidth, int lawnHeight) {
        lawn = new Lawn(lawnWidth, lawnHeight);
        mowers = new LinkedBlockingQueue<>();
    }

    public void addMower(Mower mower) {
        this.mowers.add(mower);
    }

    public void mow(List<Command> commands) {
        Mower mower = mowers.poll();
        schedule(mower, commands);
    }

    private void schedule(Mower mower, List<Command> commands) {
        new Thread(() -> execute(mower, commands)).start();
    }

    private synchronized void execute(Mower mower, List<Command> commands) {
        for (Command command : commands) {
            processCommand(mower, command);
        }
        System.out.println(mower.getState());
    }

    private void processCommand(Mower mower, Command command) {
        switch (command) {
            case ROTATE_LEFT:
            case ROTATE_RIGHT:
                mower.setDirection(processRotateCommand(mower, command));
                break;
            case FORWARD:
                Point newPosition = processMoveCommand(mower);
                if (lawn.inBounds(newPosition)) {
                    mower.setPosition(newPosition);
                }
                break;
        }
    }

    private Direction processRotateCommand(Mower mower, Command command) {
        return CommandsProcessor.rotate(mower.getDirection(), command);
    }

    private Point processMoveCommand(Mower mower) {
        return CommandsProcessor.move(mower.getPosition(), mower.getDirection());
    }
}
