package ru.mts.homeworks.service;

import ru.mts.homeworks.model.*;
import ru.mts.homeworks.exception.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class ServiceSearchImpl implements SearchService{
    public void checkLeapYearAnimal(AbstractAnimal animal) throws InvalidAnimalException,InvalidAnimalBirthDateException{
        LocalDate birthDate;
        if (animal == null)
               throw new InvalidAnimalException("На вход пришел некорректный объект "+LocalDate.now());

        birthDate = animal.getBirthDate();
        if (birthDate == null)
            throw new InvalidAnimalBirthDateException("У животного "+animal.getName()+ " не указана дата его рождения!");

              if (birthDate.isLeapYear())
                  System.out.println(animal.getName()+" рожден в високосный год!");
              else
                  System.out.println(animal.getName()+ " рожден не в високосный год!");
    }
}
