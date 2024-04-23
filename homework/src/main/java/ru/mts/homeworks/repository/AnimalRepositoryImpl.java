package ru.mts.homeworks.repository;

import ru.mts.homeworks.model.*;
import ru.mts.homeworks.exception.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnimalRepositoryImpl implements AnimalRepository {

    public Map<String, LocalDate> findLeapYearsName(List<AbstractAnimal> animalsList){
        return  animalsList.stream()
                .filter(animal -> animal.getBirthDate().isLeapYear())
                .collect(Collectors.toMap(animal->animal.getClass().getSimpleName()+" "+animal.getName()+" "+animal.getCost(),animal->animal.getBirthDate()));
    }

    public Map<AbstractAnimal, Integer> findOlderAnimal(List<AbstractAnimal> animalsList,int num) {
        Map<AbstractAnimal, Integer> olderAnimals = new HashMap<>();
        Map<AbstractAnimal, Integer> maxAgeAnimals = new HashMap<>();
        if (animalsList.size() == 0 || animalsList == null)
            throw new EmptyAnimalMapException();

        olderAnimals = animalsList.stream()
                    .filter(animal -> animal.getAge() > num)
                    .collect(Collectors.toMap(animal->animal,AbstractAnimal::getAge));

        if (olderAnimals.size() == 0)
            return animalsList.stream().filter(animal -> animal.getAge() >= animalsList.stream()
                            .mapToInt(AbstractAnimal::getAge)
                            .max()
                            .getAsInt())
                    .collect(Collectors.toMap(animal->animal,AbstractAnimal::getAge));
        return olderAnimals;
    }

    public Map<String, List<AbstractAnimal>> findDuplicate(List<AbstractAnimal> animalsList) {
       if (animalsList.size() == 0 || animalsList == null)
            throw new EmptyAnimalMapException();

       return  animalsList.stream()
               .collect(Collectors.groupingBy(AbstractAnimal::getClassName));
    }

    public Double findAverageAge (List<AbstractAnimal> animalList){
        return  animalList.stream()
                .mapToInt(AbstractAnimal::getAge)
                .average()
                .orElseThrow(()-> new RuntimeException("Не удалось найти средний возраст"));
    }

    public List<AbstractAnimal> findOlderAndExpensive(List<AbstractAnimal> animalList){
        Double average = animalList.stream().mapToDouble(AbstractAnimal::getCost).average().getAsDouble();

        return animalList.stream().filter(animal -> animal.getAge() >5)
                .filter(animal -> animal.getCost() > average)
                .sorted(Comparator.comparing(AbstractAnimal::getAge).reversed()).collect(Collectors.toList());
    }

  public  List<AbstractAnimal> findMinConstAnimals(List<AbstractAnimal> animalList){
        return animalList.stream().limit(3).sorted(Comparator.comparing(AbstractAnimal::getName).reversed()).collect(Collectors.toList());
  }
}
