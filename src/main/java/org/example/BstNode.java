package org.example;

import lombok.Data;

@Data
public class BstNode {
    private final int value;
    BstNode left, right, prev;
}
