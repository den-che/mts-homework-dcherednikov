package ru.mts.homeworks.model;

import java.time.LocalDate;

public class Shark extends Predator{
    public Shark(String name, LocalDate birthDate, String breed, Double cost, String character, String area) {
        super(name, birthDate,breed, cost, character,area);
    }
}
