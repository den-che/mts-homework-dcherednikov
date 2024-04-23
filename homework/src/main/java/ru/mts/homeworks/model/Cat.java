package ru.mts.homeworks.model;

import java.time.LocalDate;

public class Cat extends Pet{
    public Cat(String name, LocalDate birthDate, String breed, double cost, String character){
        super(name, birthDate,breed, cost, character);
    }
}
