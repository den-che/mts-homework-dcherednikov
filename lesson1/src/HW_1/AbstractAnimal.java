package HW_1;

import java.time.LocalDate;

public abstract class AbstractAnimal implements Animal {
    private String breed;
    private String name;
    private Double cost;
    private String character;
    private LocalDate birthDate;

    public String getBreed(){
        return this.breed;
    }
    public String getName(){
        return this.name;
    }
    public Double getCost(){
        return this.cost;
    }
    public String getCharacter(){
        return this.character;
    }
    public LocalDate getBirthDate(){
        return this.birthDate;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCost(Double cost){
        this.cost = cost;
    }
    public void setCharacter(String character){
        this.character = character;
    }
    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }

    public void printAnimal(){
        System.out.println("Создано животное:  "+this.getName()+"  "+this.getBreed()+"  "+this.getCost()+"  "+this.getCharacter());
    }
}
