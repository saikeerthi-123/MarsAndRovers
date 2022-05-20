package com.tw.dojo.marsRover;

public class InvalidPositionException extends Exception {
    public InvalidPositionException(String lines) {
        super("Invalid position at:"+ lines);
    }
}
