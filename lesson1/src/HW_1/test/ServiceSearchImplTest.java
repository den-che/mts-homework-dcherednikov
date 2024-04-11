package HW_1.test;

import HW_1.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ServiceSearchImplTest {

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();;
    ServiceSearchImpl serviceSearchImpl = new ServiceSearchImpl();
    PrintStream resetStream = System.out;

    @BeforeEach
    void setOutContent(){
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void resetContent(){
        System.setOut(new PrintStream(resetStream));
    }

    @Test
    @DisplayName("Проверяем животного который родился в високосный год")
    void checkLeapYearAnimal() throws InvalidAnimalBirthDateException {
        Cat cat = new Cat("Molly", LocalDate.of(2020,2,3),"ciam",80.3,"angry");
        serviceSearchImpl.checkLeapYearAnimal(cat);
        assertEquals("Molly рожден в високосный год!\n",outContent.toString());
    }

    @Test
    @DisplayName("Проверяем животного который родился не в високосный год")
    void checkNotLeapYearAnimal() throws InvalidAnimalBirthDateException {
        Cat cat = new Cat("Buddy", LocalDate.of(2021,2,3),"ciam",82.3,"angry");
        serviceSearchImpl.checkLeapYearAnimal(cat);
        assertEquals("Buddy рожден не в високосный год!\n",outContent.toString());
    }

    @Test
    @DisplayName("Проверяем Exception когда на вход поступил объект со значением null")
    void checkThrowInvalidAnimalException(){
        RuntimeException invalidAnimalException = assertThrows(InvalidAnimalException.class, ()-> serviceSearchImpl.checkLeapYearAnimal(null));
        assertEquals("На вход пришел некорректный объект 2024-04-11",invalidAnimalException.getMessage());
    }

    @Test
    @DisplayName("Проверяем Exception когда у животного не задана дата рождения")
    void checkThrowInvalidAnimalBirthDateException(){
        Cat cat = new Cat("Smile",null,"syberian",224.3,"angry");
        Exception invalidAnimalBirthdateException = assertThrows(InvalidAnimalBirthDateException.class, ()-> serviceSearchImpl.checkLeapYearAnimal(cat));
        assertEquals("У животного Smile не указана дата его рождения!",invalidAnimalBirthdateException.getMessage());
    }
}