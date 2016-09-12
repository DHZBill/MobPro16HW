package Animal;

import java.util.Random;

/**
 * Created by DHZ_Bill on 9/12/16.
 */
public class Cow extends Animal{
    public Cow(String name,
               String color)
    //String species,
    //double weight,
    //int legs)
    {
        super(name, color);
        Random rnd = new Random();
        setLegs(4);
        setSpecies("Cow");
        setWeight(Math.round(rnd.nextDouble() * 100 + 100));
    }

    public void grow(){
        setWeight(5 * getWeight());
    }

}
