package pl.edu.agh.pea.Individuals;

import java.util.Random;

public class Individual {
	private double [] genotype;
	private double fitness;
	private int dimension;
	
	public Individual (int dimension) {
		this.dimension = dimension;
		this.genotype = new double [dimension];
		randomGenotype();
	}

	public Individual (double [] genotype) {
		this.dimension = genotype.length;
		this.genotype = new double [dimension];
		this.setGenotype(genotype);
	}

	public void setFitness(double fitness){
		this.fitness = fitness;
	}

	public double getFitness(){ return this.fitness; }

	public void setGenotype( double [] genotype ) {
		for(int i = 0; i < dimension; i++){
			this.genotype[i] = genotype[i];
		}
	}

	public void randomGenotype(){
		Random randomNum = new Random();
		double value;

		for(int i = 0; i < dimension; i++){
			value = randomNum.nextDouble()*10.24 - 5.11;
			this.setGen(i, value);
		}
	}

	public double [] getGenotype(){

		return this.genotype;
	}

	public void setGen(int n, double value){
		this.genotype[n] = value;
	}

	public double getGen(int n){ return this.genotype[n]; }

	public void printIndividual () {
		System.out.print("Individual with genotype: [");

		for(double g : genotype) {
			System.out.print(String.format("%.3f", g) + " | ");
		}

		System.out.println("]");

		System.out.println("has fitness: " + String.format("%.3f", getFitness()));
	}
}
