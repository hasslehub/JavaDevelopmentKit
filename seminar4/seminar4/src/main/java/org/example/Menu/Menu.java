package org.example.Menu;

import java.util.Scanner;

public class Menu {
    public String viewMenu(){
        System.out.println("\nМеню: \n" +
                "1 - Показать всех сотрудников\n" +
                "2 - Поиск сотрудника по стажу\n" +
                "3 - Вывести номер телефона сотрудника по имени\n" +
                "4 - Поиск сотрудника по табельному номеру\n" +
                "5 - Добавить нового сотрудника в справочник\n" +
                "6 - Выход");
        System.out.print("\nВаш выбор: ");
        return new Scanner(System.in).next();
    }
}
