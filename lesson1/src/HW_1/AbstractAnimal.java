package HW_1;

public abstract class AbstractAnimal {
    private String breed;
    private String name;
    private Double cost;
    private String character;

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

    public void printAnimal(){
        System.out.println("Создано животное:  "+this.getName()+"  "+this.getBreed()+"  "+this.getCost()+"  "+this.getCharacter());
    }
}
