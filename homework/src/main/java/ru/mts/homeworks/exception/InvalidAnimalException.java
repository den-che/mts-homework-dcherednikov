package ru.mts.homeworks.exception;

public class InvalidAnimalException extends RuntimeException{
    public InvalidAnimalException(String message){
        super(message);
    }
}
