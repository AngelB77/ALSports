package com.F5.ALSports.exceptions;

public class EmptyException extends RuntimeException {
    public EmptyException() {
        super("No data");
    }
}