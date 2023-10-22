package org.example.Controller;

import org.example.Model.Directory;
import org.example.Model.Employee;
import org.example.Input.InputInt;
import org.example.Input.InputString;
import org.example.Menu.Menu;
import org.example.Menu.PrintResult;

import static org.example.Model.Directory.*;

public class Controller {
    public void run() {

        Directory DirectoryEmployee = new Directory();

        Employee employee1 = new Employee("8234567890", "Виктор", 5);
        Employee employee2 = new Employee( "8876548210", "Александр", 10);

        DirectoryEmployee.addEmployee(employee1);
        DirectoryEmployee.addEmployee(employee2);

        boolean exit = false;

        while (!exit) {
            String choice = new Menu().viewMenu();
            switch (choice) {

                //Показать всех сотрудников
                case "1" ->
                    new PrintResult().showEmployee(getEmployeeList());

                // Поиск сотрудников по стажу
                case "2" -> {
                    int target = new InputInt().input("Введите стаж сотрудника: ");
                    try {
                        System.out.println("Сотрудник со стажем " + target + ": " +
                                Directory.findBySeniority(target));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Нет данных: " + e.getMessage());
                    }
                }

                // Вывести номер телефона сотрудника по имени
                case "3" -> {
                    String target = new InputString().input("Введите имя сотрудника: ").toLowerCase();
                    try {
                        System.out.println("Номер телефона сотрудника " + target + ": " +
                                findNumberPhone(target));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Нет данных: " + e.getMessage());
                    }
                }

                //Поиск сотрудника по табельному номеру
                case "4" -> {
                    int target = new InputInt().input("Введите табельный номер сотрудника: ");
                    try {
                        Employee employee = findById(target);
                        if (employee != null) {
                            System.out.println("Сотрудник с табельным номером " + target + ": " + employee.getName());
                        }
                        else System.out.println("Сотрудник с табельным номером " + target + " не найден!\n");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Нет данных: " + e.getMessage());
                    }
                }

                // Добавить нового сотрудника в справочник
                case "5" -> {
                    try {
                        new addEmployee().newWorker(getEmployeeList());
                        new PrintResult().showEmployee(getEmployeeList());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid argument: " + e.getMessage());
                    }
                }

                case "6" ->
                    exit = true;
            }
        }
    }
}
