package org.example;

import java.util.Stack;

public class CustomStack {
    StackNode top;
    int size;

    public void push(StackNode stackNode) {
        if (top == null) {
            top = stackNode;
        }
        size++;
    }
    public StackNode pop() {
        if (top == null) {
           throw new StackEmptyException();
        }
        StackNode result = top;
        top = top.prev;
        size--;
        return result;
    }

    public StackNode peak() {
        return top;
    }

    public int size() {
        return size;
    }
}
