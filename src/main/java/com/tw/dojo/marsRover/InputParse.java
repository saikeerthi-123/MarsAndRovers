package com.tw.dojo.marsRover;

import java.util.Arrays;

public class InputParse {



    static Position inititalPosition(String lines) throws InvalidPositionException {
        int xIndex, yIndex;

        try {
            String[] split = lines.split(" ");

            xIndex = Integer.parseInt(split[0]);
            yIndex = Integer.parseInt(split[1]);
        } catch (RuntimeException e) {
            throw new InvalidPositionException(lines);
        }

        return new Position(xIndex,yIndex);
    }
    static String initialDirection(String lines) {
        String direction;

        try {
            direction = lines.split(" ")[2];
            if (!Arrays.asList("N", "E", "S", "W").contains(direction)) {
                throw new IllegalArgumentException();
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Could not parse direction from: " + lines);
        }
        return direction;
    }
}
