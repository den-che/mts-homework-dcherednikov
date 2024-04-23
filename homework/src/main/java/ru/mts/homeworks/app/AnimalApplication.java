package ru.mts.homeworks.app;

import ru.mts.homeworks.model.*;
import ru.mts.homeworks.service.*;
import ru.mts.homeworks.repository.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class AnimalApplication{
    public static void main(String[] args) throws Exception {
        int num = 3;
        List<AbstractAnimal> animalsList = new ArrayList<>();
        CreateAnimalServiceImpl createAnimalService = new CreateAnimalServiceImpl();
        Map<String, List<AbstractAnimal>> animals2 = createAnimalService.createAnimal();;
        System.out.println(animals2);
        Map<String, List<AbstractAnimal>> animals = createAnimalService.createAnimal(6);

        AnimalRepositoryImpl animalRepositoryImpl = new AnimalRepositoryImpl();
        System.out.println(animals);

        for(String key : animals.keySet()){
            animalsList.addAll(animals.get(key));
        }

        Map<String, LocalDate> leapYearAnimals = animalRepositoryImpl.findLeapYearsName(animalsList);
        if (leapYearAnimals .size() == 0){
            System.out.println("Животные родились не в високостный год");
        }
        else {
            System.out.println("Животные которые родились в високостный год: \n "+leapYearAnimals );
        }

        Map<AbstractAnimal, Integer> olderAnimals = animalRepositoryImpl.findOlderAnimal(animalsList, num);
        System.out.println("Животные которые старше "+num+" лет: \n"+olderAnimals);

        Map<String, List<AbstractAnimal>> duplicates = animalRepositoryImpl.findDuplicate(animalsList);
        System.out.println("Количество дубликатов животных: \n"+duplicates);

        System.out.println("Средний возраст всех животных равен\n"+animalRepositoryImpl.findAverageAge(animalsList));

        System.out.println("Животные которые старше и дороже\n"+animalRepositoryImpl.findOlderAndExpensive(animalsList));

        System.out.println("Животное с минимальной стоимость\n"+animalRepositoryImpl.findMinConstAnimals(animalsList));
    }
}
