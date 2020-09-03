package com.ezbob.task.exceptions;

public abstract class TaskException extends Exception{
    public TaskException(String message) {
        super(message);
    }
}
