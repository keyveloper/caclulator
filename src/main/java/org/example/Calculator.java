package org.example;

// cal.c 파일이 될 예정
public class Calculator {
    double result = 0;
    // cal
    public double processCommand(String command) {
        BstNode root = BstMaker.setTree(command);
        return traversalPostOrder(root);
    }

    private double traversalPostOrder(BstNode root) {
        if (root != null) {
            if (checkOperator(root.getValue())) {
                // check double or char[]
                return calculate(root.getValue(), )
            }
        }
    }

    private boolean checkOperator(char operator) {
        return operator == '*' || operator == '+' || operator == '/' || operator == '%' || operator == '^'
                || operator == '-';
    }

//    private int parseInt(char[] operand) {
//        return Integer.parseInt(operand);
//    }

    private double calculate(char operator, int op1, int op2) {

    }



}
