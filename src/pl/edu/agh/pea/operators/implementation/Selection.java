package pl.edu.agh.pea.operators.implementation;

import java.util.PriorityQueue;

import pl.edu.agh.pea.core.ProblemParameters;
import pl.edu.agh.pea.individuals.Individual;
import pl.edu.agh.pea.operators.Operator;

public class Selection extends Operator {

    private final IndividualComparator comparator = new IndividualComparator();

    protected void doOperation() {
        PriorityQueue<Individual> heap = new PriorityQueue<>(comparator);

        heap.addAll(population);

        this.population.clear();
        for (int i = 0; i < ProblemParameters.population; i++) {
            population.add(heap.poll());
        }
    }
}