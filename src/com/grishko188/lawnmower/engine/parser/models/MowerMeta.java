package com.grishko188.lawnmower.engine.parser.models;

import com.grishko188.lawnmower.engine.models.utils.Command;
import com.grishko188.lawnmower.engine.models.utils.Direction;
import com.grishko188.lawnmower.engine.models.utils.Point;
import com.sun.istack.internal.NotNull;

import java.util.List;

public class MowerMeta {

    @NotNull
    private Point position;
    @NotNull
    private Direction direction;
    @NotNull
    private List<Command> commands;

    public MowerMeta(@NotNull Point position, @NotNull Direction direction, @NotNull List<Command> commands) {
        this.position = position;
        this.direction = direction;
        this.commands = commands;
    }

    @NotNull
    public Point getPosition() {
        return position;
    }

    @NotNull
    public Direction getDirection() {
        return direction;
    }

    @NotNull
    public List<Command> getCommands() {
        return commands;
    }
}
