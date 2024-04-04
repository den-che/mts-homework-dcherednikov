package HW_1;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class ServiceSearchImpl implements SearchService{
    public void checkLeapYearAnimal(AbstractAnimal animal) throws InvalidAnimalException,InvalidAnimalBirthDateException{
        LocalDate birthDate;
        if (animal == null)
               throw new InvalidAnimalException("На вход пришел некорректный объект "+LocalDate.now());

        birthDate = animal.getBirthDate();
        if (birthDate == null)
            throw new InvalidAnimalBirthDateException("У животного "+animal.getName()+ " не указана дата его рождения!");

              if (birthDate.isLeapYear())
                  System.out.println("Bисокосный год!");
              else
                  System.out.println("Не високосный год!");

    }
}
