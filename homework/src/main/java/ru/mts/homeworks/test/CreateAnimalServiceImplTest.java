package ru.mts.homeworks.test;

import ru.mts.homeworks.model.*;
import ru.mts.homeworks.exception.*;
import ru.mts.homeworks.service.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class CreateAnimalServiceImplTest {
    CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();

    @Test
    @DisplayName("Проверяем создание животных в Override")
    void createAnimalOverride() throws InvalidAnimalBirthDateException {
        int countAnimals = 1;

        List<AbstractAnimal> animalsList= new ArrayList<>();
        Map<String, List<AbstractAnimal>> animals = createAnimalServiceImpl.createAnimal();
        for (String key : animals.keySet()){
            animalsList.addAll(animals.get(key));
        }
        assertEquals(5,animalsList.size());
    }

    @Test
    @DisplayName("Проверяем создание N количества животных")
    void createAnimalWithNumber() throws InvalidAnimalBirthDateException {
        List<AbstractAnimal> animalsList= new ArrayList<>();
        Map<String, List<AbstractAnimal>> animals = createAnimalServiceImpl.createAnimal(3);
        for (String key : animals.keySet()){
            animalsList.addAll(animals.get(key));
        }
        assertEquals(3,animalsList.size());
    }
}