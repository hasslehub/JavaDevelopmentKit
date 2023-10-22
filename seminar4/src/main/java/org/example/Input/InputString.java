package org.example.Input;

import java.util.Scanner;

public class InputString {
    public String input(String text){
        System.out.print(text);
        return new Scanner(System.in).next();
    }
}
