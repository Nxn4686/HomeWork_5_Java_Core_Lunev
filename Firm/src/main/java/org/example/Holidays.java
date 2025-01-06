package org.example;

import java.time.LocalDate;

public enum Holidays {
    NONE("Обычный день"),
    NEW_YEAR("Поздравляем с Новым Годом!"),
    WOMENS_DAY("Поздравляем с 8-м марта!"),
    DEFENDERS_DAY("Поздравляем с Днем Защитника Отечества!");

    public final String russianHolidaysTitle;

    // Конструктор для русского текста
    Holidays(String russianHolidaysTitle) {
        this.russianHolidaysTitle = russianHolidaysTitle;
    }

    public String getRussianHolidaysTitle() {
        return russianHolidaysTitle;
    }

    public static Holidays getCurrentHoliday(LocalDate date){

        LocalDate today = date;

        if(today.getMonthValue() == 1 && today.getDayOfMonth() == 1) {
            return Holidays.NEW_YEAR;
        }

        else if (today.getMonthValue() == 3 && today.getDayOfMonth() == 8) {
            return Holidays.WOMENS_DAY;
        }

        else if(today.getMonthValue() == 2 && today.getDayOfMonth() == 23) {
            return Holidays.DEFENDERS_DAY;
        }

        return Holidays.NONE;
    }

    public static void greetEmployees(Employee[] employees, LocalDate date) {

        Holidays currentHoliday = getCurrentHoliday(date);

        switch (currentHoliday) {
            case NEW_YEAR:
            for (Employee employee : employees) {
                System.out.println(employee.getName() + " " + Holidays.NEW_YEAR.getRussianHolidaysTitle());
            }
                break;
            case WOMENS_DAY:
                for (Employee employee : employees) {
                    if (employee.getMale().getRussianMaleTitle().equals("женский")) {
                        System.out.println(employee.getName() + " " + Holidays.WOMENS_DAY.getRussianHolidaysTitle());
                    }
                }
                break;
            case DEFENDERS_DAY:
                    for (Employee employee : employees) {
                        if (employee.getMale().getRussianMaleTitle().equals("мужской")) {
                            System.out.println(employee.getName() + " " + Holidays.DEFENDERS_DAY.getRussianHolidaysTitle());
                        }
                    }
                break;
            default:
                for (Employee employee : employees) {
                    System.out.println(Holidays.NONE.getRussianHolidaysTitle());
                }
        }


    }

    @Override
    public String toString() {
        return name();
    }
}
