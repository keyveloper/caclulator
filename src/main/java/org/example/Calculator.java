package org.example;

import java.util.Stack;

// cal.c 파일이 될 예정
public class Calculator {
    // cal

    public double calculate(String command) {
        String postfix = makePostfix(command);
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Node root = binarySearchTree.setTree(postfix);


    }

    public String makePostfix(String formulas) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        if (!isValid(formulas)) {
            return null;
        }

        for (int i = 0; i < formulas.length(); i++) {
            char c = formulas.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
                continue;
            }

            if (c == '(') {
                stack.push(c);
                continue;
            }

            if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
                continue;
            }
            //  연산자인 경우, 우선순위가 높은 놈부터 넣는다. stack에 대기하다가.
            while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(c)) {
                postfix.append(stack.pop());
            }
            postfix.append(c);
        }
        return postfix.toString();
    }

    private boolean isValid(String formulas) {
        return formulas.matches("[0-9+\\-*/%^()]");
    }

    private int getPriority(char operator) {
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
