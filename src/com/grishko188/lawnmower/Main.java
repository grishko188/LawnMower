package com.grishko188.lawnmower;

import com.grishko188.lawnmower.engine.LawnMowerController;
import com.grishko188.lawnmower.engine.errors.IncorrectInputFileException;
import com.grishko188.lawnmower.engine.models.Mower;
import com.grishko188.lawnmower.engine.parser.InputParser;
import com.grishko188.lawnmower.engine.parser.models.Meta;
import com.grishko188.lawnmower.engine.parser.models.MowerMeta;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                String input = readAllBytes(args[0]);
                System.out.println("---- Input ----\n" + input + "\n---------------");

                Meta meta = new InputParser().parse(input);
                LawnMowerController controller = new LawnMowerController(meta.getLawnWidth(), meta.getLawnHeight());

                for (MowerMeta mowerMeta : meta.getMowerMetaData()) {
                    controller.addMower(new Mower(mowerMeta.getPosition(), mowerMeta.getDirection()));
                }

                for (MowerMeta mowerMeta : meta.getMowerMetaData()) {
                    controller.mow(mowerMeta.getCommands());
                }
            } catch (Throwable error) {
                System.out.println("Unexpected error:\n" + error.toString());
            }
        } else {
            System.out.println("Input file not provided");
        }
    }

    private static String readAllBytes(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new IncorrectInputFileException("Cannot read input file. Path: {" + filePath + "}");
        }
    }
}
