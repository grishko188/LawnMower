package com.grishko188.lawnmower.engine.parser.models;

import com.grishko188.lawnmower.engine.models.utils.Command;
import com.grishko188.lawnmower.engine.models.utils.Direction;
import com.grishko188.lawnmower.engine.models.utils.Point;

import java.util.List;

public class MowerMeta {

    private Point position;
    private Direction direction;
    private List<Command> commands;

    public MowerMeta(Point position, Direction direction, List<Command> commands) {
        this.position = position;
        this.direction = direction;
        this.commands = commands;
    }

    public Point getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<Command> getCommands() {
        return commands;
    }
}
