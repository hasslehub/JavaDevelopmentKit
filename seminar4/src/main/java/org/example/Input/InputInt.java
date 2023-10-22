package org.example.Input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputInt {

    public int input(String text) {
        System.out.print(text);
        int value;
        try {
            value = new Scanner(System.in).nextInt();
            return value;
        }catch (InputMismatchException e){
            System.out.println("Ошибка ввода: введите число");
            return input(text);
        }
    }
}
