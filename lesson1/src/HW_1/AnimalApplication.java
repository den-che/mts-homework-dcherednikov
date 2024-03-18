package HW_1;

public class AnimalApplication{
    public static void main(String[] args) {
        CreateAnimalServiceImpl createAnimalService = new CreateAnimalServiceImpl();
        createAnimalService.createAnimal();
        createAnimalService.createAnimal(2);
    }
}
