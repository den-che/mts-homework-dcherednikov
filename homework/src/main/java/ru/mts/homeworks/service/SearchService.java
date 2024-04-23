package ru.mts.homeworks.service;

import ru.mts.homeworks.model.*;
import ru.mts.homeworks.exception.*;

public interface SearchService {
    void checkLeapYearAnimal(AbstractAnimal animal) throws InvalidAnimalBirthDateException;
}
