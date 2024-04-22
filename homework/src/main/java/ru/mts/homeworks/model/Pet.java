package ru.mts.homeworks.model;

import java.time.LocalDate;

public class Pet extends AbstractAnimal{
    public Pet(String name, LocalDate birthDate, String breed,  double cost, String character){
        this.setName(name);
        this.setBirthDate(birthDate);
        this.setBreed(breed);
        this.setCost(cost);
        this.setCharacter(character);
    }
}
