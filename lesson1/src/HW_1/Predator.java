package HW_1;

import java.time.LocalDate;

public class Predator extends AbstractAnimal {
    private String area;
    public Predator(String name, LocalDate birthDate, String breed, String area, String character){
        this.setName(name);
        this.setBirthDate(birthDate);
        this.setBreed(breed);
        this.setCharacter(character);
        this.area = area;
    }
    public String getArea(){
        return this.area;
    }
    @Override
    public void printAnimal(){
        System.out.println("Создано животное:  "+this.getName()+" "+this.getBreed()+" "+this.getCharacter()+"  "+this.getArea());
    }
}
