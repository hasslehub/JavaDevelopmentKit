package org.example.Menu;

import org.example.Model.Employee;

import java.util.List;

public class PrintResult {
    public void showEmployee(List<Employee> employeeList) {
        for (Employee worker : employeeList) {
            System.out.println(worker);
        }
    }
}
