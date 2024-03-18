package HW_1;

import java.sql.Array;
import java.util.Objects;

public interface CreateAnimalService {
    default void createAnimal(){
        int count = 0;

        String[] animalsClass = new String[]{"Cat", "Dog", "Shark", "Wolf"};
        String[] catNames = new String[]{"муська", "дуська", "паштет", "барсик"};
        String[] catBreed = new String[]{"британская", "бирманская", "бенгальская", "абиссинская"};
        String[] dogBreed = new String[]{"бульдог", "бигль", "", "абиссинская"};
        String[] dogNames = new String[]{"муська", "дог", "мухтар", "барсик", "мухтар"};
        String [] characters = new String []{"Агрессивный","Опасный","Мягкий","Безобидный"};
        String [] sharkBreed = new String[]{"Тигровая","Молот","Китовая","Большая белая"};
        String [] area = new String[]{"океан","лес","пустыня"};
        String [] wolfBreed = new String[]{"степной","красный","тасманский сумчатый","гривистый"};


        while (count < 10 ){
            AbstractAnimal objectName = null;
            String objValue = animalsClass[(int) Math.round(Math.random() * (animalsClass.length-1))];

            if (Objects.equals("Cat",objValue)) {
                objectName = new Cat(catNames[(int) (Math.random() * catNames.length)], catBreed[(int) (Math.random() * catBreed.length)], (int) (Math.random()*200.0), characters[(int) (Math.random() * characters.length)]);
            }
            else if (Objects.equals("Dog",objValue)) {
                objectName = new Dog(dogNames[(int) (Math.random() * dogNames.length)], dogBreed[(int) (Math.random() * catBreed.length)], (int)(Math.random() * 200.0), characters[(int) (Math.random() * characters.length)]);
            }
            else if (Objects.equals("Shark",objValue)) {
                objectName = new Shark("акула", sharkBreed[(int) (Math.random() * sharkBreed.length)],area[(int) (Math.random() * area.length)],  characters[(int) (Math.random() * characters.length)]);
            }
            else if (Objects.equals("Wolf",objValue)) {
                objectName = new Wolf("волк", wolfBreed[(int) (Math.random() * wolfBreed.length)],area[(int) (Math.random() * area.length)],  characters[(int) (Math.random() * characters.length)]);
            }
            objectName.printAnimal();

            count++;
        }

    }
}
