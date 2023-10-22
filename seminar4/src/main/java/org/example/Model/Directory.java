package org.example.Model;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private static List<Employee> employeeList;

    public Directory() {
        employeeList = new ArrayList<>();
    }


    // Добавить метод, который ищет сотрудника по стажу (может быть список)
    public static List<Employee> findBySeniority(int seniority){
        if (seniority < 0) {
            throw new IllegalArgumentException("Стаж не может быть отрицательным\n");
        }
        List<Employee> resultEmployee = new ArrayList<>();
        for (Employee employee:employeeList) {
            if (employee.getSeniority() == seniority){
                resultEmployee.add(employee);
            }
        }
        if (resultEmployee.isEmpty()){
            throw new IllegalArgumentException("Сотрудник со стажем " + seniority + " не найден!\n");
        }
        return resultEmployee;
    }


    // Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
    public static List<String> findNumberPhone(String name){
        if (name == null) {
            throw new IllegalArgumentException("Имя не может быть null\n");
        }
        List<String> resultEmployee = new ArrayList<>();
        for (Employee employee:employeeList) {
            if (employee.getName().toLowerCase().equals(name)){
                resultEmployee.add(employee.getPhoneNumber());
            }
        }
        if (resultEmployee.isEmpty()){
            throw new IllegalArgumentException("Сотрудник с именем " + name + " не найден!\n");
        }
        return resultEmployee;
    }

    // Добавить метод, который ищет сотрудника по табельному номеру
    public static Employee findById(int Id){
        if (Id <= 0) {
            throw new IllegalArgumentException("Табельный номер должен быть больше нуля!\n");
        }
        for (Employee employee:employeeList) {
            if (employee.getId() == Id){
                return employee;
            }
        }
        return null;
    }

    // Добавить метод добавление нового сотрудника в справочник сотрудников
    public void addEmployee(Employee employee){
        if (employee != null) {
            employeeList.add(employee);
        }
    }

    public static List<Employee> getEmployeeList() {
        return employeeList;
    }
}

