package Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * Created by DHZ_Bill on 9/12/16.
 */
public class Farm {
    ArrayList<Animal> ListOfAnimals= new ArrayList<Animal>();

    public void addAnimal(Animal ani){
        ListOfAnimals.add(ani);
    }

    public Animal getAnimal(int n){
        return ListOfAnimals.get(n);
    }

    public ArrayList<Animal> getHeaviestAnimals(){
        ArrayList<Animal> heaviestAnimals = new ArrayList(ListOfAnimals);
        Collections.sort(heaviestAnimals, new Comparator<Animal>() {
            @Override
            public int compare(Animal ani1, Animal ani2){
                return Double.compare(ani2.getWeight(), ani1.getWeight());
            }
        });
        return heaviestAnimals;
        }
        



    public void printCatNames(){
        for (int i=0; i< ListOfAnimals.size(); i++) {
            Animal ani = ListOfAnimals.get(i);
            if (ani.getSpecies() == "Cat"){
                System.out.println(ani.getName());
            }
            
        }
    }

    public double averageLegs(){
        double total = 0;
        for (int i=0; i< ListOfAnimals.size(); i++) {
            Animal ani = ListOfAnimals.get(i);
            total += ani.getLegs();
        }
        return (total/ListOfAnimals.size());


    }
}

