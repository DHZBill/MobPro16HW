package Animal;
import java.util.Random;
/**
 * Created by DHZ_Bill on 9/12/16.
 */
public class Cat extends Animal{

    Random rnd = new Random();


    public Cat(
        String name,
        String color)
        //String species,
        //double weight,
        //int legs)
               {
            super(name, color);
            setLegs(4);
            setSpecies("Cat");
            setWeight(Math.round(rnd.nextDouble() * 25));
    }

    public void grow(){
        setWeight(3 * getWeight());
    }
}
