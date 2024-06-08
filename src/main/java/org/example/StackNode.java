package org.example;

import lombok.Data;

@Data
public class StackNode {
    StackNode prev;
    private final char data;
}
