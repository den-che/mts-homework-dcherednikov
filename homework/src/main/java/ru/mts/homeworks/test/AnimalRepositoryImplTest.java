package ru.mts.homeworks.test;

import ru.mts.homeworks.model.*;
import ru.mts.homeworks.repository.*;
import ru.mts.homeworks.exception.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnimalRepositoryImplTest {
    AnimalRepositoryImpl animalRepository = new AnimalRepositoryImpl();
    List<AbstractAnimal> animalList = new ArrayList<>();

    @BeforeEach
    void setAnimalsValue(){
        animalList.add(new Cat("Kitty",LocalDate.of(2020,10,10),"ciam",89.43,"agressive"));
        animalList.add(new Wolf("Wolf",LocalDate.of(1990,3,10),"wooden",36.4,"agressive","forest"));
        animalList.add(new Cat("Bamby",LocalDate.of(2005,3,10),"syberian",120.43,"kind"));
        animalList.add(new Cat("Buddy",LocalDate.of(2020,3,10),"syberian",120.43,"kind"));
        animalList.add(new Cat("Angry",LocalDate.of(2008,3,10),"syberian",120.43,"kind"));
    }

    void resetAnimalList(){
        animalList.clear();
    }

    @Test
    @DisplayName("Проверяем животных которые рождены в високостный год")
    void findLeapYearsName() {
        Map<String, LocalDate> leapYearsName = animalRepository.findLeapYearsName(animalList);
        assertEquals(3,leapYearsName.size());
    }

    @Test
    @DisplayName("Проверяем животных которые рождены старше N лет")
    void findOlderAnimal() {
        Map<AbstractAnimal, Integer> olderAnimals = animalRepository.findOlderAnimal(animalList,50);

        for (AbstractAnimal obj: olderAnimals.keySet()){
            assertEquals(34,olderAnimals.get(obj));
        }
        assertEquals(3,animalRepository.findOlderAnimal(animalList,10).size());
        assertEquals(5,animalRepository.findOlderAnimal(animalList,2).size());
    }

    @Test
    @DisplayName("Проверяем количество найденных животных")
    void findDuplicate() {
        Map<String, List<AbstractAnimal>> duplicates = animalRepository.findDuplicate(animalList);
        assertEquals(1,duplicates.get("Wolf").size());
        assertEquals(4,duplicates.get("Cat").size());
    }

    @Test
    @DisplayName("Проверяем Exception когда список животных пустой в методе findDuplicate")
    void checkEmptyAnimalMapExeptionDuplicate(){
        resetAnimalList();
        RuntimeException emptyAnimalMapException = assertThrows(EmptyAnimalMapException.class, () -> animalRepository.findDuplicate(animalList));
        assertEquals("На вход пришел пустой список животных!",emptyAnimalMapException.getMessage());
    }
    @Test
    @DisplayName("Проверяем Exception когда список животных пустой в методе findOlderAnimal")
    void checkEmptyAnimalMapExeptionfindOlder(){
        resetAnimalList();
        RuntimeException emptyAnimalMapException = assertThrows(EmptyAnimalMapException.class, () -> animalRepository.findOlderAnimal(animalList,4));
        assertEquals("На вход пришел пустой список животных!",emptyAnimalMapException.getMessage());
    }

    @Test
    @DisplayName("Поиск среднего возраста")
    void findAverageAge(){
        Double average = animalRepository.findAverageAge(animalList);
        assertEquals(15.2,average);
    }

    @Test
    @DisplayName("Поиск самого старшего и дорогого животного")
    void findOlderAndExpensive(){
        List<AbstractAnimal> olderAndExpensive = animalRepository.findOlderAndExpensive(animalList);
        System.out.println(olderAndExpensive);
        assertEquals(2, olderAndExpensive.size());
        assertEquals(120.43,olderAndExpensive.get(0).getCost());
        assertEquals(120.43,olderAndExpensive.get(1).getCost());
    }

    @Test
    @DisplayName("Поиск минимального по стоимости животного")
    void findMinConstAnimals(){
        List<AbstractAnimal> minCostAnimals = animalRepository.findMinConstAnimals(animalList);
        System.out.println(minCostAnimals);
        assertEquals(3, minCostAnimals.size());
        assertEquals(36.4,minCostAnimals.get(0).getCost());
        assertEquals(89.43,minCostAnimals.get(1).getCost());
        assertEquals(120.43,minCostAnimals.get(2).getCost());
    }
}