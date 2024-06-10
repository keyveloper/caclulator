package org.example;

import lombok.Data;

@Data
public class BstNode {
    private char value;
    BstNode left, right, prev;
}
