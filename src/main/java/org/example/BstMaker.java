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
                // remove ('(')
                operators.pop();
                continue;
            }

            // operator -> check priority!
            if (isOperator(value)) {
                while (operators.size() != 0 && getPriority(operators.peak().getData()) >= getPriority(value)) {
                    bstNodes.push(setSubtree(operators.pop().getData(), bstNodes));
                }
                operators.push(new StackNode(value));
            }
        }
        return bstNodes.pop();
    }

    private static BstNode setSubtree(char operator, CustomBstStack bstNodes) {
        BstNode right = bstNodes.pop();
        BstNode left = bstNodes.pop();
        BstNode node = new BstNode(operator);
        node.setLeft(left);
        node.setRight(right);
        return node;
    }

    private static boolean isOperator(char op) {
        // 이거 로직 생각해보기
        return true;
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

