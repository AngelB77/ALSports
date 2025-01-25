package com.F5.ALSports.exeptions;

public class EmptyException extends RuntimeException {
    public EmptyException() {
        super("No data");
    }
}
