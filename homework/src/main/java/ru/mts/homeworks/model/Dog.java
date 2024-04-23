package ru.mts.homeworks.model;

import java.time.LocalDate;

public class Dog extends Pet{
    public Dog(String name, LocalDate birthDate,String breed, double cost, String character){
        super(name, birthDate, breed, cost, character);
    }
}
