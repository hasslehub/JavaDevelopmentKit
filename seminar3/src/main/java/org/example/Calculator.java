package org.example;

 /*
    Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
    sum(), multiply(), divide(), subtract().
    Параметры этих методов – два числа разного типа (но необязательно разного между собой),
    над которыми должна быть произведена операция.
 */

public class Calculator {

    public static <T extends Number> T sum(T a, T b) {
        return (T) Double.valueOf(a.doubleValue() + b.doubleValue()); //(T) res;
    }

    public static <T extends Number> T multiply(T a, T b) {
        return (T) Double.valueOf(a.doubleValue() * b.doubleValue()); //(T) res;
    }

    public static <T extends Number> T divide(T a, T b) {
        return (T) Double.valueOf(a.doubleValue() / b.doubleValue()); //(T) res;
    }

    public static <T extends Number> T subtract(T a, T b) {
        return (T) Double.valueOf(a.doubleValue() - b.doubleValue()); //(T) res;
    }

}
