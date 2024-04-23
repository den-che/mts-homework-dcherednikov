package ru.mts.homeworks.repository;

import ru.mts.homeworks.model.*;
import java.time.LocalDate;
import java.util.Map;
import java.util.List;

public interface AnimalRepository {
    Map<String, LocalDate> findLeapYearsName(List<AbstractAnimal> animalsList);
    Map<AbstractAnimal,Integer> findOlderAnimal(List<AbstractAnimal> animalsList, int num);
    Map<String, List<AbstractAnimal>> findDuplicate(List<AbstractAnimal> animalsList);

    Double findAverageAge (List<AbstractAnimal> animalList);

    List<AbstractAnimal> findOlderAndExpensive(List<AbstractAnimal> animalList);
    List<AbstractAnimal> findMinConstAnimals(List<AbstractAnimal> animalList);

}
