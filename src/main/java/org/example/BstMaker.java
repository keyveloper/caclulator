package org.example;

import lombok.Data;

@Data
public class BstMaker {
    public static BstNode setTree(String infix) {
        CustomStack operators = new CustomStack();
        CustomBstStack bstNodes = new CustomBstStack();
        for (char value : infix.toCharArray()) {
            if (Character.isDigit(value)) {
                bstNodes.push(new BstNode(value));
                continue;
            }

            if (value == '(') {
                operators.push(new StackNode(value));
                continue;
            }

            if (value == ')') {
                while (operators.peak().getData() != '(') {
                    bstNodes.push(setSubtree(value, bstNodes));
                }
            }
        }

    }

    private static BstNode setSubtree(char operator, CustomBstStack bstNodes) {
        BstNode right = bstNodes.pop();
        BstNode left = bstNodes.pop();
        BstNode node = new BstNode(operator);
        node.setLeft(left);
        node.setRight(right);
        return node;
    }

    private static int getPriority(char operator) {
        switch (operator) {
            case '+', '-' -> {
                return 1;
            }
            case '*', '/', '%' ->  {
                return 2;
            }
            case '^' -> {
                return 3;
            }
        }
        return 0;
    }
}

