package pl.edu.agh.pea.individuals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pl.edu.agh.pea.operators.implementation.IndividualComparator;

public class Island {

    private List<Individual> population;
    private final IndividualComparator comparator = new IndividualComparator();

    public Island (){
        this.population = new ArrayList<Individual>();
    }

    public List<Individual> getPopulation(){
        return population;
    }

    public void setPopulation (List<Individual> individuals){
        if(individuals == null){
            throw new IllegalArgumentException("You cannot set null population on island");
        }
        population.addAll(individuals);
    }

    public void addIndividual(Individual individual){
        if(individual == null){
            throw new IllegalArgumentException("You cannot add null to population of island");
        }

        population.add(individual);
    }

    public void immigrate(List<Individual> individuals){
        if(individuals == null){
            throw new IllegalArgumentException("Null cannot immigrate to island");
        }

        population.addAll(individuals);
        Collections.sort(population, comparator);
    }

    public List<Individual> emigrate(int x){
        if ( x > population.size()){
            throw new IndexOutOfBoundsException("Cannot emigrate");
        }

        List<Individual> list = new ArrayList<Individual>(population.subList(0, x));
        population.removeAll(list);
        return list;
    }

}
