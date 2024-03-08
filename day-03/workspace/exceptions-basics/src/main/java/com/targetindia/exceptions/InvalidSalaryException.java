package com.targetindia.exceptions;

public class InvalidSalaryException extends RuntimeException{
    public InvalidSalaryException() {
    }

    public InvalidSalaryException(String message) {
        super(message);
    }

    public InvalidSalaryException(Throwable cause) {
        super(cause);
    }
}
