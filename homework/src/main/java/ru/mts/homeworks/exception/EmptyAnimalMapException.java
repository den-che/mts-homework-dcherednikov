package ru.mts.homeworks.exception;

public class EmptyAnimalMapException extends RuntimeException{
    private static final String ERR_MESSAGE = "На вход пришел пустой список животных!";

    public EmptyAnimalMapException(){
        super(ERR_MESSAGE);
    }
}
