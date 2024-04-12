package HW_1;

import java.time.LocalDate;
import java.util.*;

public class CreateAnimalServiceImpl implements CreateAnimalService{
    LocalDate birthdate = LocalDate.of(2021,1,8);
    LocalDate birthdate2 = LocalDate.of(2020,1,8);

    public HashMap<String, List<AbstractAnimal>> createAnimal(int num) throws InvalidAnimalBirthDateException {
        HashMap<String, List<AbstractAnimal>> animals = new HashMap<>();
        for (int idx = 0; idx < num; idx++) {
            List<AbstractAnimal> animalList = new ArrayList<>();
            AbstractAnimal objectName = null;
            String objValue = animalsClass[(int) Math.round(Math.random() * (animalsClass.length-1))];

            if (Objects.equals("Cat",objValue))
                objectName = new Cat(catNames[(int) (Math.random() * catNames.length)], birthdate, catBreed[(int) (Math.random() * catBreed.length)], (int) (Math.random() * 200.0), characters[(int) (Math.random() * characters.length)]);
            else if (Objects.equals("Dog",objValue)) {
                objectName = new Dog(dogNames[(int) (Math.random() * dogNames.length)],birthdate2 , dogBreed[(int) (Math.random() * catBreed.length)], (int)(Math.random() * 200.0), characters[(int) (Math.random() * characters.length)]);
            }
            else if (Objects.equals("Shark",objValue)) {
                objectName = new Shark("акула",birthdate ,sharkBreed[(int) (Math.random() * sharkBreed.length)],area[(int) (Math.random() * area.length)],  characters[(int) (Math.random() * characters.length)]);
            }
            else if (Objects.equals("Wolf",objValue)) {
                objectName = new Wolf("волк", birthdate2,wolfBreed[(int) (Math.random() * wolfBreed.length)],area[(int) (Math.random() * area.length)],  characters[(int) (Math.random() * characters.length)]);
            }

            if (animals.containsKey(objValue)){
                animalList = animals.get(objValue);
            }
            animalList.add(objectName);
            animals.put(objValue,animalList);

            ServiceSearchImpl serviceSearch = new ServiceSearchImpl();
            try{
                serviceSearch.checkLeapYearAnimal(objectName);
            }catch (InvalidAnimalBirthDateException e){
                    throw new InvalidAnimalBirthDateException("Работа метода завершилась с ошибкой.",e);
            }
        }
        return animals;
    }

    @Override
    public HashMap<String, List<AbstractAnimal>> createAnimal() throws InvalidAnimalBirthDateException {
        int count = 0;
        HashMap<String, List<AbstractAnimal>> animals = new HashMap<>();
        do {
            List<AbstractAnimal> animalList = new ArrayList<>();
            AbstractAnimal objectName = null;
            String objValue = animalsClass[(int) Math.round(Math.random() * (animalsClass.length-1))];

            if (Objects.equals("Cat",objValue)) {
                objectName = new Cat(catNames[(int) (Math.random() * catNames.length)],birthdate, catBreed[(int) (Math.random() * catBreed.length)], (int) (Math.random()*200.0), characters[(int) (Math.random() * characters.length)]);
            }
            else if (Objects.equals("Dog",objValue)) {
                objectName = new Dog(dogNames[(int) (Math.random() * dogNames.length)],birthdate, dogBreed[(int) (Math.random() * catBreed.length)], (int)(Math.random() * 200.0), characters[(int) (Math.random() * characters.length)]);
            }
            else if (Objects.equals("Shark",objValue)) {
                objectName = new Shark("акула", birthdate,sharkBreed[(int) (Math.random() * sharkBreed.length)],area[(int) (Math.random() * area.length)],  characters[(int) (Math.random() * characters.length)]);
            }
            else if (Objects.equals("Wolf",objValue)) {
                objectName = new Wolf("волк", birthdate,wolfBreed[(int) (Math.random() * wolfBreed.length)],area[(int) (Math.random() * area.length)],  characters[(int) (Math.random() * characters.length)]);
            }
            count++;

            if (animals.containsKey(objValue)){
                animalList = animals.get(objValue);
            }
            animalList.add(objectName);
            animals.put(objValue,animalList);

            ServiceSearchImpl serviceSearch = new ServiceSearchImpl();
            try{
                serviceSearch.checkLeapYearAnimal(objectName);
            }catch (InvalidAnimalBirthDateException e){
                throw new InvalidAnimalBirthDateException("Работа метода завершилась с ошибкой.",e);
            }
        }
        while (count < 5);
        return animals;
    }
}
