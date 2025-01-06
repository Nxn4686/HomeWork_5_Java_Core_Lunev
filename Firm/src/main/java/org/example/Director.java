package org.example;

import java.util.List;

public class Director extends Employee {
    public Director(String name, double salary, String birthday, Male male) {
        super(name, salary, birthday, male);
    }

    // Статический метод для повышения зарплаты всех сотрудников, кроме руководителей
    public static void increaseSalary(List<Employee> employees) {
        for (Employee employee : employees) {
            if (!(employee instanceof Director)) {
                employee.setSalary(employee.getSalary() * 1.1); // Повышение на 10%
            }
        }
    }
}
