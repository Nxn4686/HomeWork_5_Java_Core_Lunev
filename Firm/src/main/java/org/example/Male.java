package org.example;

public enum Male {
    MALE("мужской"), FEMALE("женский");

    public final String russianMaleTitle;

    //Конструктор для русского текста
    Male(String russianMaleTitle){
        this.russianMaleTitle = russianMaleTitle;
    }

    public String getRussianMaleTitle() {
        return russianMaleTitle;
    }

    @Override
    public String toString() {
        return name();
    }
}
