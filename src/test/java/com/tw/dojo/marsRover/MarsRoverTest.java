package com.tw.dojo.marsRover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// DO NOT CHANGE
public class MarsRoverTest {

    private MarsRover rover;

    @BeforeEach
    public void setUp() {
        rover = new MarsRover();
    }

    @Test
    public void shouldMoveRoverAround() {
        assertThat(rover.run("5 5\n" + "1 1 N\n" + "MM\n"), is("1 3 N\n"));
    }

    @Test
    public void shouldTurnRoverRight() {
        assertThat(rover.run("5 5\n" + "1 1 N\n" + "RRR\n"), is("1 1 W\n"));
    }

    @Test
    public void shouldTurnRoverLeft() {
        assertThat(rover.run("5 5\n" + "1 1 N\n" + "LLL\n"), is("1 1 E\n"));
    }

    @Test
    public void shouldMoveMultipleRoversCorrectly() {
        String in = "5 5\n" +
                "1 2 N\n" +
                "LMLMLMLMM\n" +
                "3 3 E\n" +
                "MMRMMRMRRM";

        assertThat(rover.run(in), is("1 3 N\n5 1 E\n"));
    }
}
