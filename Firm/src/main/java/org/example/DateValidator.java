package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator {

    public static LocalDate parseDate(String dateInput) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            return LocalDate.parse(dateInput, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Неверный формат даты. Ожидаемый формат: yyyy-MM-dd");
            return null;
        }
    }

}

