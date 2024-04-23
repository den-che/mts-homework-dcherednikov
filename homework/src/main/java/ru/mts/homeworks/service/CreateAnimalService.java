package ru.mts.homeworks.service;

import ru.mts.homeworks.model.*;
import ru.mts.homeworks.exception.*;

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

    default HashMap<String, List<AbstractAnimal>> createAnimal() throws InvalidAnimalBirthDateException {
        int count = 0;
        HashMap<String, List<AbstractAnimal>> animals = new HashMap<>();
        while (count < 10 ){
            List<AbstractAnimal> animalList = new ArrayList<>();
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
                objectName = new Shark("акула",birthdate, sharkBreed[(int) (Math.random() * sharkBreed.length)],Math.random() * 200.0,area[(int) (Math.random() * area.length)],  characters[(int) (Math.random() * characters.length)]);
            }
            else if (Objects.equals("Wolf",objValue)) {
                objectName = new Wolf("волк",birthdate ,wolfBreed[(int) (Math.random() * wolfBreed.length)],Math.random() * 200.0,area[(int) (Math.random() * area.length)],  characters[(int) (Math.random() * characters.length)]);
            }

            count++;

            if (animals.containsKey(objValue)){
                animalList = animals.get(objValue);
            }
            animalList.add(objectName);
            animals.put(objValue,animalList);
        }
        return animals;
    }
}
