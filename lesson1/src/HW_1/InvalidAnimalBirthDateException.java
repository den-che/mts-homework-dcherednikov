package HW_1;

public class InvalidAnimalBirthDateException extends Exception{
    public InvalidAnimalBirthDateException(String message){
        super(message);
    }
    public InvalidAnimalBirthDateException(String message, Throwable cause){
        super(message,cause);
    }
}
