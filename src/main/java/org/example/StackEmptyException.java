package org.example;

public class StackEmptyException extends RuntimeException{
    public StackEmptyException() {
        super("Stack is empty");
    }
}
