package pl.edu.agh.pea.core;

import pl.edu.agh.pea.individuals.Individual;
import pl.edu.agh.pea.operators.Operator;
import pl.edu.agh.pea.operators.OperatorFactory;

import java.util.*;

public class Core {	
	private List<Individual> population;
	private List<Operator> operators;
	
	public Core(List<Individual> population, List<Operator> operators){
		this.population = population;
		this.operators = operators;
	}
	
	public void solve(){
		Individual bestInGeneration;
		double [] bestInGenerationArray = new double [ProblemParameters.getGenerations()];
		
		for(int i = 0; i < ProblemParameters.getGenerations(); i++){
			bestInGeneration = processGeneration();
			System.out.println("Generation " + i);
			bestInGenerationArray[i] = bestInGeneration.getFitness();
			bestInGeneration.printIndividual();
		}
		
		ChartDrawer.drawPlot(bestInGenerationArray);
	}
	
	public Individual getBestIndividual(){
		return population.get(0);
	}
	
	private Individual processGeneration(){

		for(Operator operator: operators){
			operator.setInputPopulation(population);
			operator.execute();
		}
	
		return getBestIndividual();
	}
	
	
	public List<Individual> getPopulation(){
		return population;
	}
	
	
	public static void main(String[] args) {
		
		if(args.length != 1){
			System.out.println("Usage: PEA <config_file>");
			return;
		}
		
		IParametersImporter ipm = new ParametersFromFile(args[0]);
		
		if(ipm.importParameters() == false) {
			return;
		}
		
		List<Operator> operators = OperatorFactory.getOperatorList(Arrays.asList("Crossover","Mutation","Evaluation","Selection"));
		List<Individual> population = new ArrayList<Individual>();
		for(int i = 0; i < ProblemParameters.getPopulation(); i++) {
			population.add(new Individual(ProblemParameters.getDimensions()));
		}
			
		Core c = new Core(population, operators);
		
		c.solve();
	}

}
