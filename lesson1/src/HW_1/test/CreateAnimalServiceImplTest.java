package HW_1.test;

import HW_1.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class CreateAnimalServiceImplTest {
    @Test
    void createAnimalOverride() {
        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();
        createAnimalServiceImpl.createAnimal();
    }

    @Test
    void createAnimalNumber() {
        CreateAnimalServiceImpl createAnimalServiceImpl = new CreateAnimalServiceImpl();
        createAnimalServiceImpl.createAnimal(3);
    }

    @Test
    void checkLeapYearAnimalTest() {
        ServiceSearchImpl serviceSearchImpl = new ServiceSearchImpl();
        AbstractAnimal wolfTest = new Wolf("волк", LocalDate.of(2022,1,8),"степной","опасный","степнь");

    }
}