package com.tw.dojo.marsRover;

import java.util.Arrays;
import java.util.List;

public class MarsRover {
    Position position;
    Direction direction;
    List<Commands> commands;


    public String run(String input) throws InvalidPositionException {
        String out = "";

        String[] lines = input.split("\n");

        int numberOfRovers = (lines.length - 1) / 2;

        for (int i = 0; i < numberOfRovers; i++) {
            int positionLineIndex = i * 2 + 1;
            int commandLineIndex = positionLineIndex + 1;

            Position position = InputParse.inititalPosition(lines[positionLineIndex]);

            String direction = InputParse.initialDirection(lines[positionLineIndex]);

            String[] commandArray = lines[commandLineIndex].split("(?!^)");

            List<String> validCommands = Arrays.asList("L", "R", "M");
            for (String command : commandArray) {
                if (!validCommands.contains(command)) {
                    throw new IllegalArgumentException("Invalid command sequence: " + lines[commandLineIndex]);
                }
            }

            for (String command : commandArray) {
                if (command.equals("M")) {
                    int[] newPosition = new int[2];

                    if (direction.equals("N")) {
                        newPosition[1] += +1;
                    } else if (direction.equals("S")) {
                        newPosition[1] += -1;
                    } else if (direction.equals("E")) {
                        newPosition[0] += +1;
                    } else if (direction.equals("W")) {
                        newPosition[0] += -1;
                    }

//                    position = newPosition;
                } else if (command.equals("R")) {
                    List<String> all = Arrays.asList("N", "E", "S", "W");
                    direction = all.get((all.indexOf(direction) + 1) % all.size());
                } else if (command.equals("L")) {
                    List<String> all = Arrays.asList("N", "E", "S", "W");
                    direction = all.get((all.indexOf(direction) + 3) % all.size());
                }
            }

//            out += position[0] + " " + position[1] + " " + direction + "\n";
        }

        return out;
    }




}
