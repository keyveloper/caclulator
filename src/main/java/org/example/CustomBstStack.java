package org.example;

public class CustomBstStack {
    BstNode top;
    int size;

    public void push(BstNode bstNode) {
        if (top == null) {
            top = bstNode;
        }
        size++;
    }
    public BstNode pop() {
        if (top == null) {
            throw new StackEmptyException();
        }
        BstNode result = top;
        top = top.prev;
        size--;
        return result;
    }

    public BstNode peak() {
        return top;
    }

    public int size() {
        return size;
    }
}
