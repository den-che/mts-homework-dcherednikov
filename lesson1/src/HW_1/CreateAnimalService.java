package HW_1;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public interface CreateAnimalService{
    String[] animalsClass = new String[]{"Cat", "Dog", "Shark", "Wolf"};
    String[] catNames = new String[]{"муська", "дуська", "паштет", "барсик"};
    String[] catBreed = new String[]{"британская", "бирманская", "бенгальская", "абиссинская"};
    String[] dogBreed = new String[]{"бульдог", "бигль", "спаниэль", "абиссинская"};
    String[] dogNames = new String[]{"муська", "дог", "мухтар", "барсик", "мухтар"};
    String [] characters = new String []{"Агрессивный","Опасный","Мягкий","Безобидный"};
    String [] sharkBreed = new String[]{"Тигровая","Молот","Китовая","Большая белая"};
    String [] area = new String[]{"океан","лес","пустыня"};
    String [] wolfBreed = new String[]{"степной","красный","тасманский сумчатый","гривистый"};
    String keyVal = "";
    HashMap<String, List<AbstractAnimal>> animals = new HashMap<>();

    default HashMap<String, List<AbstractAnimal>> createAnimal() throws InvalidAnimalBirthDateException {
        List<AbstractAnimal> animalList = new ArrayList<>();
        int count = 0;
        String keyVal = "";

        while (count < 10 ){
            AbstractAnimal objectName = null;
            String objValue = animalsClass[(int) Math.round(Math.random() * (animalsClass.length-1))];
            LocalDate birthdate = LocalDate.of(2020,1,8);

            if (Objects.equals("Cat",objValue)) {
                objectName = new Cat(catNames[(int) (Math.random() * catNames.length)], null ,catBreed[(int) (Math.random() * catBreed.length)], (int) (Math.random()*200.0), characters[(int) (Math.random() * characters.length)]);
            }
            else if (Objects.equals("Dog",objValue)) {
                objectName = new Dog(dogNames[(int) (Math.random() * dogNames.length)], birthdate, dogBreed[(int) (Math.random() * catBreed.length)], (int)(Math.random() * 200.0), characters[(int) (Math.random() * characters.length)]);
            }
            else if (Objects.equals("Shark",objValue)) {
                objectName = new Shark("акула",birthdate, sharkBreed[(int) (Math.random() * sharkBreed.length)],area[(int) (Math.random() * area.length)],  characters[(int) (Math.random() * characters.length)]);
            }
            else if (Objects.equals("Wolf",objValue)) {
                objectName = new Wolf("волк",birthdate ,wolfBreed[(int) (Math.random() * wolfBreed.length)],area[(int) (Math.random() * area.length)],  characters[(int) (Math.random() * characters.length)]);
            }

            count++;

            if (animals.size() > 0) {
                for (String key : animals.keySet()) {
                    keyVal = objValue;
                    if (objValue.equals(key)) {
                        animalList = animals.get(objValue);
                        break;
                    }
                }
                animalList.add(animalList.size(), objectName);
                animals.put(keyVal, animalList);
            } else {
                animalList.add(0, objectName);
                animals.put(objValue, animalList);
            }
        }
        return animals;
    }
}
