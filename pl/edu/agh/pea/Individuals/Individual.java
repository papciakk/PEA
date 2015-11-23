package pl.edu.agh.pea.Individuals;

import java.util.Random;
import pl.edu.agh.pea.Core.ProblemParameters;

public class Individual implements Cloneable {
	public double [] x;
	private double fitness;
	
	private int dimmensions;
	
	private double ACoefficient;
	
	private Random rand;
	
	public Individual (ProblemParameters problemParameters, boolean init) {
		this.dimmensions = problemParameters.dimensions;
		this.ACoefficient = problemParameters.ACoefficient;
		x = new double [dimmensions];
		
		if(init) {
			rand = new Random();
			randomPopulation ();
		}
	}
	
	public void randomPopulation () {
		for (int i = 0; i < dimmensions; i++) {
			x[i] = rand.nextDouble() * 10.24 - 5.12;
		}
	}
	
	public void printPopulation () {
		updateFitness();
		System.out.println("Fitness: " + String.format("%.3f", getFitness()));
		
		System.out.print("Genome: [");
		for(double ch : x) {
			System.out.print(String.format("%.3f", ch) + " ");
		}
		System.out.println("]");
	}
	
	public void updateFitness() {		
		fitness = ACoefficient*dimmensions;
		for(int i = 0; i < dimmensions; i++) {
			fitness += x[i]*x[i] - ACoefficient*Math.cos(2.0*Math.PI*x[i]); 
		}
	}
	
	public double getFitness() {
		return fitness;
	}
	
	public Individual clone() throws CloneNotSupportedException {
        return (Individual) super.clone();
    }
}
