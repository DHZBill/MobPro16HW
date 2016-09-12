package Animal;

/**
 * Created by DHZ_Bill on 9/11/16.
 */
public abstract class Animal {
    private int legs;
    private String name;
    private String color;
    private String species;
    private double weight;

    public Animal(
                  String name,
                  String color
                  //String species,
                  //double weight,
                  //int legs
    ){
        //this.legs = legs;
        this.legs = 0;
        this.color = color;
        this.name = name;
        this.species = "";
        this.weight = 0;




    }


    public int getLegs(){
        return this.legs;
    }

    public String getName(){
        return this.name;
    }

    public String getColor(){
        return this.color;
    }

    public String getSpecies(){
        return this.species;
    }

    public double getWeight(){
        return this.weight;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract void grow();


}
