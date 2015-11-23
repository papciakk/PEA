package pl.edu.agh.pea.Individuals;

import java.util.Random;
import pl.edu.agh.pea.Core.ProblemParameters;

public class Individual implements Cloneable {
	private double [] genotype;
	private double fitness;
	private int dimmension;
	private double ACoefficient;
	private Random rand;
	
	public Individual (ProblemParameters problemParameters) {
		this.dimmensions = problemParameters.dimensions;
		this.ACoefficient = problemParameters.ACoefficient;
		genotype = new double [dimmensions];
		setFitness();
	}

	public void setFitness(){
		fitness = ACoefficient*dimmensions;

		for(int i = 0; i < dimmensions; i++) {
			fitness += x[i]*x[i] - ACoefficient*Math.cos(2.0*Math.PI*x[i]);
		}
	}

	public void updateFitness() {
		//TODO - aktualizuje fitness
	}

	public double getFitness() {
		return fitness;
	}

	public void updateGenotype(){
		//TODO - aktualizuje genotyp osobnika
	}

	public void updateGen(int n){
		//TODO - zmienia konkretny gen
	}

	public void randomGenotype(){
		//TODO - zwraca losowy genotyp osobnika
	}

	public void setGen(){
		//TODO - ustawia gen
	}

	public [] double getGenotype(){
		//TODO - zwraca tablice z genotypem
	}

	public double getGen(int n){
		//TODO - zwraca gen o indeksie n
	}

	public void printIndividual () {
		System.out.print("Individual with genotype: [");

		for(double g : genotype) {
			System.out.print(String.format("%.3f", g) + " | ");
		}

		System.out.println("]");

		System.out.println("has fitness: " + String.format("%.3f", getFitness()));
	}
	

}
