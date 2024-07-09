package com.java.java_full_stack.exception;

public class EmployeeAlreadyExistException extends RuntimeException {
    public EmployeeAlreadyExistException(String message) {

        super(message);
    }
}
