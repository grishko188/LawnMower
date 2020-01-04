package com.grishko188.lawnmower.engine;

import com.grishko188.lawnmower.engine.models.Lawn;
import com.grishko188.lawnmower.engine.models.Mower;
import com.grishko188.lawnmower.engine.models.Command;
import com.grishko188.lawnmower.engine.models.Direction;
import com.grishko188.lawnmower.engine.models.Point;
import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.*;

public class LawnMowerController {

    private Lawn lawn;
    private Queue<Mower> mowers;
    private Map<Mower, Callback> callbacks;
    private ExecutorService executor;

    public LawnMowerController(int lawnWidth, int lawnHeight) {
        lawn = new Lawn(lawnWidth, lawnHeight);
        mowers = new LinkedBlockingQueue<>();
        callbacks = new HashMap<>();
        executor = Executors.newSingleThreadExecutor();
    }

    public void addMower(@NotNull Mower mower, Callback callback) {
        this.mowers.add(mower);
        this.callbacks.put(mower, callback);
    }

    public void mow(@NotNull List<Command> commands) {
        Mower mower = mowers.poll();
        schedule(mower, commands);
        shutdownIfEmpty();
    }

    private void schedule(Mower mower, List<Command> commands) {
        executor.submit(() -> execute(mower, commands));
    }

    private synchronized void execute(Mower mower, List<Command> commands) {
        for (Command command : commands) {
            processCommand(mower, command);
        }
        callbacks.remove(mower).onMowFinished(mower.getState());
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

    private void shutdownIfEmpty() {
        if (mowers.isEmpty()) {
            executor.shutdown();
        }
    }

    public interface Callback {
        void onMowFinished(String output);
    }
}
