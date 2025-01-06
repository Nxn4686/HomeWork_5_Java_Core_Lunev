package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee("Ivan", 50000, "1985-02-15", Male.MALE);
        Employee employee2 = new Employee("Olga", 45000, "1984-02-15", Male.FEMALE);
        Employee employee3 = new Employee("Sergey", 43000, "1984-02-15", Male.MALE);
        Employee employee4 = new Employee("Nina", 47000, "1984-02-15", Male.FEMALE);
        Employee employee5 = new Employee("Dmitry", 43000, "1984-02-15", Male.MALE);

        Director director1 = new Director("Elena",100000, "1975-11-10", Male.FEMALE);

        /**
         * Семинар 4. Задание 1.
         * В класс покупателя добавить перечисление с гендерами, добавить в сотрудника свойство «пол
         * со значением созданного перечисления. Добавить геттеры, сеттеры.
         */

        System.out.println("Семинар 4, Задание 1:");
        System.out.println("\nПол покупателя:");

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(director1);

        for (Employee employee : employees) {
            System.out.println(employee.getMale().getRussianMaleTitle());
        }

        System.out.println("\nСеминар 4, Задание 2:");

        /**
         * Семинар 4. Задание 2.
         * Добавить в основную программу перечисление с праздниками (нет праздника, Новый Год, 8 марта, 23 февраля),
         * написать метод, принимающий массив сотрудников, поздравляющий всех сотрудников с Новым Годом,
         * женщин с 8 марта, а мужчин с 23 февраля, если сегодня соответствующий день.
         */

        Employee[] employeesHoliday = {employee1, employee2, employee3, employee4, employee5};

        DateValidator dateValidator = new DateValidator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите дату в формате yyyy-MM-dd:");
        String inputDate = scanner.nextLine();

        LocalDate localDate = dateValidator.parseDate(inputDate);

        Holidays.greetEmployees(employeesHoliday, localDate);

        scanner.close();

        /**
         * Семинар 3.
         */

        System.out.println("\nЗадания из семинара №3:");


        System.out.println("\nКомпаратор сравнения возраста сотрудника:\n" + Employee.compareDates(director1.getBirthday(), employee1.getBirthday()));

        System.out.println("\nПовышение зарплаты (кроме руководителя):\nЗарплаты до повышения:");
        for (Employee employee : employees) {
            System.out.println("Зарплата " + employee.getName() + ": " + employee.getSalary());
        }

        Director.increaseSalary(employees);

        System.out.println("\nЗарплаты после повышения:");
        for (Employee employee : employees) {
            System.out.println("Зарплата " + employee.getName() + ": " + String.format("%.1f", employee.getSalary()));
        }
    }
}