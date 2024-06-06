package org.example;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Calculator calculator = new Calculator();

        try {
            while (true) {
                String command = bufferedReader.readLine();
                if (command.equals("\r\n")) {
                    break;
                }
                System.out.println("result: " + calculator.calculate() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}