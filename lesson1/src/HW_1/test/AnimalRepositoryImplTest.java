package HW_1.test;

import HW_1.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnimalRepositoryImplTest {
    AnimalRepositoryImpl animalRepository = new AnimalRepositoryImpl();

    @BeforeEach
    void setAnimalsValue(){
        animalRepository.addList(new Cat("Kitty",LocalDate.of(2020,10,10),"ciam",89.43,"agressive"));
        animalRepository.addList(new Wolf("Wolf",LocalDate.of(1990,3,10),"wooden","agressive","forest"));
        animalRepository.addList(new Cat("Bamby",LocalDate.of(2005,3,10),"syberian",120.43,"kind"));
        animalRepository.addList(new Cat("Buddy",LocalDate.of(2020,3,10),"syberian",120.43,"kind"));
        animalRepository.addList(new Cat("Angry",LocalDate.of(2008,3,10),"syberian",120.43,"kind"));
    }


    @Test
    @DisplayName("Проверяем животных которые рождены в високостный год")
    void findLeapYearsName() {
        Map<String, LocalDate> leapYearsName = animalRepository.findLeapYearsName();
        System.out.println(leapYearsName.size());
        assertEquals(3,leapYearsName.size());
    }

    @Test
    @DisplayName("Проверяем животных которые рождены старше N лет")
    void findOlderAnimal() {
        Map<AbstractAnimal, Integer> olderAnimals = animalRepository.findOlderAnimal(20);
        System.out.println(olderAnimals);
        for (AbstractAnimal obj: olderAnimals.keySet()){
            assertEquals(34,olderAnimals.get(obj));
        }

        assertEquals(3,animalRepository.findOlderAnimal(10).size());
        assertEquals(5,animalRepository.findOlderAnimal(2).size());
    }

    @Test
    @DisplayName("Проверяем количество найденных животных")
    void findDuplicate() {
        Map<String, Integer> duplicates = animalRepository.findDuplicate();
        System.out.println(duplicates);
        assertEquals(1,duplicates.get("Wolf"));
        assertEquals(4,duplicates.get("Cat"));
    }

    @Test
    @DisplayName("Проверяем Exception когда список животных пустой в методе findDuplicate")
    void checkEmptyAnimalMapExeptionDuplicate(){
        animalRepository.clear();
        RuntimeException emptyAnimalMapException = assertThrows(EmptyAnimalMapException.class, () -> findDuplicate());
        assertEquals("На вход пришел пустой список животных!",emptyAnimalMapException.getMessage());
    }
    @Test
    @DisplayName("Проверяем Exception когда список животных пустой в методе findOlderAnimal")
    void checkEmptyAnimalMapExeptionfindOlder(){
        animalRepository.clear();
        RuntimeException emptyAnimalMapException = assertThrows(EmptyAnimalMapException.class, () -> findOlderAnimal());
        assertEquals("На вход пришел пустой список животных!",emptyAnimalMapException.getMessage());
    }
}