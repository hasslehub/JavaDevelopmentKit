package org.example;


import static org.example.ArrayCompare.compareArrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(Calculator.sum(2, 4));
        System.out.println(Calculator.multiply(2, 8.1));
        System.out.println(Calculator.divide(13, 2));
        System.out.println(Calculator.subtract(12, 4.2));


        String[] ss1 = new String[]{"a", "b", "c"};
        String[] ss2 = new String[]{"a", "b", "c"};
        System.out.println(compareArrays(ss1, ss2));


        Pair<String, Double> product = new Pair<>("Test", 1.0);
        System.out.println(product);

    }
}