package HW_1;

import java.time.LocalDate;
import java.util.Map;
import java.util.List;

public class AnimalApplication{
    public static void main(String[] args) throws Exception {
        int num = 3;
        CreateAnimalServiceImpl createAnimalService = new CreateAnimalServiceImpl();
     //   createAnimalService.createAnimal();
        Map<String, List<AbstractAnimal>> animals = createAnimalService.createAnimal(6);

        AnimalRepositoryImpl animalRepositoryImpl = new AnimalRepositoryImpl();
        animalRepositoryImpl.createAnimalList(animals);
        System.out.println(animals);

        Map<String, LocalDate> leapYearAnimals = animalRepositoryImpl.findLeapYearsName();
        if (leapYearAnimals .size() == 0){
            System.out.println("Животные родились не в високостный год");
        }
        else {
            System.out.println("Животные которые родились в високостный год: \n "+leapYearAnimals );
        }

        Map<AbstractAnimal, Integer> olderAnimals = animalRepositoryImpl.findOlderAnimal(num);
        System.out.println("Животные которые старше "+num+" лет: \n"+olderAnimals);

        Map<String, Integer> duplicates = animalRepositoryImpl.findDuplicate();
        System.out.println("Количество дубликатов животных: \n"+duplicates);
    }
}
