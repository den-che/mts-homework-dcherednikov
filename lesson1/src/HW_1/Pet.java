package HW_1;

public class Pet extends AbstractAnimal{
    public Pet(String name, String breed, double cost, String character){
        this.setName(name);
        this.setBreed(breed);
        this.setCost(cost);
        this.setCharacter(character);
    }
}
