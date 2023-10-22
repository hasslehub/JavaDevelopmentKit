package org.example.Controller;

import org.example.Model.Employee;
import org.example.Input.InputInt;
import org.example.Input.InputString;

import java.util.List;

public class addEmployee {
    public void newWorker(List<Employee> employeeList) {
        employeeList.add(new Employee(
                new InputString().input("Введите номер телефона: "),
                new InputString().input("Введите имя: "),
                new InputInt().input("Введите стаж: ")));
    }
}
