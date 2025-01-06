package org.example;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Data
public class Employee {
    private final String name;
    private double salary;
    private final LocalDate birthday;
    private final Male male;

    // Конструктор
    public Employee(String name, double salary, String birthday, Male male) {
        this.name = name;
        this.salary = salary;
        this.birthday = parseBirthday(birthday);
        this.male = male;
    }

    // Геттеры
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    // Сеттеры
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Метод для парсинга даты
    private LocalDate parseBirthday(String birthday) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(birthday, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Некорректный формат даты! Ожидается формат yyyy-MM-dd.");
            return null;
        }
    }

    // Прототип метода-компаратора для сравнения двух дат
    public static String compareDates(LocalDate date1, LocalDate date2) {
        int result = Integer.signum(date1.compareTo(date2));
        // Массив строк для возможных результатов сравнения
        String[] outcomes = {
                "Первый сотрудник старше второго.",
                "Сотрудники родились в один день.",
                "Первый сотрудник младше второго."
        };

        // Используем результат сравнения как индекс в массиве
        return outcomes[(result + 1)];
    }
}
