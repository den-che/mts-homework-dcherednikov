package HW_1;

import java.time.LocalDate;
import java.util.Objects;

public class CreateAnimalServiceImpl implements CreateAnimalService{
    LocalDate birthdate = LocalDate.of(2021,1,8);
    public void createAnimal(int num) {
        int count = 0;

        System.out.println("Перегруженный метод!");

        for (int idx = 0; idx < num; idx++) {

            AbstractAnimal objectName = null;
            String objValue = animalsClass[(int) Math.round(Math.random() * (animalsClass.length-1))];

            if (Objects.equals("Cat",objValue))
                objectName = new Cat(catNames[(int) (Math.random() * catNames.length)], birthdate, catBreed[(int) (Math.random() * catBreed.length)], (int) (Math.random() * 200.0), characters[(int) (Math.random() * characters.length)]);
            else if (Objects.equals("Dog",objValue)) {
                objectName = new Dog(dogNames[(int) (Math.random() * dogNames.length)],birthdate , dogBreed[(int) (Math.random() * catBreed.length)], (int)(Math.random() * 200.0), characters[(int) (Math.random() * characters.length)]);
            }
            else if (Objects.equals("Shark",objValue)) {
                objectName = new Shark("акула",birthdate ,sharkBreed[(int) (Math.random() * sharkBreed.length)],area[(int) (Math.random() * area.length)],  characters[(int) (Math.random() * characters.length)]);
            }
            else if (Objects.equals("Wolf",objValue)) {
                objectName = new Wolf("волк", birthdate,wolfBreed[(int) (Math.random() * wolfBreed.length)],area[(int) (Math.random() * area.length)],  characters[(int) (Math.random() * characters.length)]);
            }
            objectName.printAnimal();

            ServiceSearchImpl serviceSearch = new ServiceSearchImpl();
            try{
                serviceSearch.checkLeapYearAnimal(objectName);
            }catch (InvalidAnimalBirthDateException e){
                try {
                    throw new InvalidAnimalBirthDateException("Работа метода завершилась с ошибкой.",e);
                } catch (InvalidAnimalBirthDateException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }
    }

    @Override
    public void createAnimal()  {
        System.out.println("Переопределеный метод!");
        int count = 0;
        do {

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
            objectName.printAnimal();

            count++;

            ServiceSearchImpl serviceSearch = new ServiceSearchImpl();
            try{
                serviceSearch.checkLeapYearAnimal(objectName);
            }catch (InvalidAnimalBirthDateException e){
                try {
                    throw new InvalidAnimalBirthDateException("Работа метода завершилась с ошибкой.",e);
                } catch (InvalidAnimalBirthDateException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }
        while (count < 5);
    }
}
