package ru.mts.homeworks.model;

import java.time.LocalDate;

public class Wolf extends Predator{
    public Wolf(String name, LocalDate birthDate, String breed, Double cost, String character, String area) {
        super(name,birthDate ,breed, cost, character, area);
    }
}
