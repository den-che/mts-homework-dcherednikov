package HW_1;

import java.time.LocalDate;
import java.util.Map;
import java.util.List;

public interface AnimalRepository {
    Map<String, LocalDate> findLeapYearsName(List<AbstractAnimal> animalsList);
    Map<AbstractAnimal,Integer> findOlderAnimal(List<AbstractAnimal> animalsList, int num);
    Map<String, Integer> findDuplicate(List<AbstractAnimal> animalsList);
}
