package Animal;

import java.util.Random;

/**
 * Created by DHZ_Bill on 9/12/16.
 */
public class Dog extends Animal{
    public Dog(String name,
               String color)
    //String species,
    //double weight,
    //int legs)
    {
        super(name, color);
        Random rnd = new Random();
        setLegs(4);
        setSpecies("Dog");
        setWeight(Math.round(rnd.nextDouble() * 25));
    }

    public void grow(){
        setWeight(1.5 * getWeight());
    }
}
