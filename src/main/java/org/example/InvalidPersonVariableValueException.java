package org.example;

public class InvalidPersonVariableValueException extends RuntimeException {
    public InvalidPersonVariableValueException() {
    }

    public InvalidPersonVariableValueException(String message) {
        super(message);
    }
}
