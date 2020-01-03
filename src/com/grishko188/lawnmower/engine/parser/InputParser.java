package com.grishko188.lawnmower.engine.parser;

import com.grishko188.lawnmower.engine.models.utils.Command;
import com.grishko188.lawnmower.engine.models.utils.Direction;
import com.grishko188.lawnmower.engine.models.utils.Point;
import com.grishko188.lawnmower.engine.parser.models.Meta;
import com.grishko188.lawnmower.engine.parser.models.MowerMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputParser {

    public Meta parse(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input, "\r\n");
        validateInputs(tokenizer.countTokens());
        Meta meta = new Meta();
        parseLawnSize(meta, tokenizer.nextToken());
        parseMowerInfo(meta, tokenizer);
        return meta;
    }

    private void parseLawnSize(Meta meta, String sizeInput) {
        String[] digits = sizeInput.split(" ");
        meta.setLawnWidth(Integer.parseInt(digits[0]));
        meta.setLawnHeight(Integer.parseInt(digits[1]));
    }

    private void parseMowerInfo(Meta meta, StringTokenizer tokenizer) {
        int mowersCount = tokenizer.countTokens() / 2;
        List<MowerMeta> result = new ArrayList<>(mowersCount);

        for (int i = 0; i < mowersCount; i++) {
            String positionToken = tokenizer.nextToken();
            String commandsToken = tokenizer.nextToken();

            String[] digits = positionToken.split(" ");

            Point position = Point.of(Integer.parseInt(digits[0]), Integer.parseInt(digits[1]));
            Direction direction = Direction.valueOfKey(digits[2]);
            List<Command> commands = parseCommands(commandsToken.toCharArray());

            result.add(new MowerMeta(position, direction, commands));
        }
        meta.setMowerMetaData(result);
    }

    private List<Command> parseCommands(char[] chars) {
        List<Command> commands = new ArrayList<>(chars.length);
        for (char commandKey : chars) {
            commands.add(Command.valueOfKey(String.valueOf(commandKey)));
        }
        return commands;
    }

    private void validateInputs(int linesCount) {
        if ((linesCount - 1) % 2 != 0)
            throw new IllegalStateException("Incorrect input files");
    }
}
