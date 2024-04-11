package HW_1;

import HW_1.AbstractAnimal;
import HW_1.AnimalRepository;
import HW_1.EmptyAnimalMapException;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class AnimalRepositoryImpl implements AnimalRepository {

    private List<AbstractAnimal> animalsList = new ArrayList<>();

    public void createAnimalList(Map<String, List<AbstractAnimal>> animals){
        for(String key : animals.keySet()){
            animalsList.addAll(animals.get(key));
         }
    }
    public void addList (AbstractAnimal animal){
        animalsList.add(animal);
    }

    public void clear(){
        animalsList.clear();
    }

    public Map<String, LocalDate> findLeapYearsName(){
        Map <String, LocalDate> leapYearsNames = new HashMap<>();
            for(AbstractAnimal objVal : animalsList){
                if (objVal.getBirthDate().isLeapYear()){
                    leapYearsNames.put(objVal.getClass().getSimpleName()+" "+objVal.getName(), objVal.getBirthDate());
                }
            }
        return leapYearsNames;
    }

    public Map<AbstractAnimal, Integer> findOlderAnimal(int num) {
        Map<AbstractAnimal, Integer> olderAnimals = new HashMap<>();
        Map<AbstractAnimal, Integer> maxAgeAnimals = new HashMap<>();

        int ageMax = 0;
        LocalDate currentDate = LocalDate.now();

        if (animalsList.size() == 0 || animalsList == null)
            throw new EmptyAnimalMapException();

        for(AbstractAnimal animal : animalsList){
                int age = Period.between(animal.getBirthDate(),currentDate).getYears();
                if(age > num){
                    olderAnimals.put(animal,age);
                }

                if (age >= ageMax){
                    ageMax = age;
                    maxAgeAnimals.put(animal,ageMax);
                }
            }
        if (olderAnimals.size() == 0)
            return maxAgeAnimals;
        return olderAnimals;
    }

    public Map<String, Integer> findDuplicate() {
        if (animalsList.size() == 0 || animalsList == null)
            throw new EmptyAnimalMapException();

        Map<String,Integer> duplicates = new HashMap<>();
        for(AbstractAnimal objVal : animalsList){
            String animalType = objVal.getClass().getSimpleName();
            if (duplicates.size() == 0 || duplicates.get(animalType) == null){
                duplicates.put(animalType,1);
            }
            else{
                duplicates.put(animalType,duplicates.get(animalType)+1);
            }
        }
        return duplicates;
    }
}
