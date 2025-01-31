package com.F5.ALSports.exeptions;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String objectName, int id) {
        super("Could not find " + objectName + " with id " + id);
    }
}
