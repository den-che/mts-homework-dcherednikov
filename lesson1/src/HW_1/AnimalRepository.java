package HW_1;

import java.time.LocalDate;
import java.util.Map;
import java.util.List;

public interface AnimalRepository {
    Map<String, LocalDate> findLeapYearsName();
    Map<AbstractAnimal,Integer> findOlderAnimal(int num);
    Map<String, Integer> findDuplicate();
    void createAnimalList(Map<String, List<AbstractAnimal>> animals);
}
