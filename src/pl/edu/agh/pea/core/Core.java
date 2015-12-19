package pl.edu.agh.pea.core;

import pl.edu.agh.pea.individuals.Individual;
import pl.edu.agh.pea.operators.Operator;
import pl.edu.agh.pea.operators.OperatorFactory;

import java.util.*;

////core version 1.2

public class Core {	
	private static List<Individual> population;
	private List<Operator> operators;
	
	private IParametersImporter parametersImporter;
	
	/*public core(IParametersImporter parametersImporter){
		this.parametersImporter = parametersImporter;
	}*/
	
	public Core(IParametersImporter parametersImporter, List<Individual> population, List<Operator> operators)
	{
		this.parametersImporter = parametersImporter;
		this.population = population;
		this.operators = operators;
	}
	
	public void solve()
	{
		Individual bestInGeneration;
		double [] bestInGenerationArray = new double [ProblemParameters.generations];
		
		for(int i = 0; i < ProblemParameters.generations; i++)
		{
			bestInGeneration = processGeneration();
			System.out.println("Generation " + i);
			bestInGenerationArray[i] = bestInGeneration.getFitness();
			bestInGeneration.printIndividual();
		}
		
		//ChartDrawer.drawPlot(bestInGenerationArray);
	}
	
	public Individual getBestIndividual()
	{
		return population.get(0);
	}
	
	private Individual processGeneration(){

		for(Operator operator: operators){
			operator.setInputPopulation(population);
			operator.execute();
		}
	
		return getBestIndividual();
	}
	
	
	public static List<Individual> getPopulation(){
		return population;
	}
	
	
	public static void main(String[] args) {
		
		if(args.length != 1)
		{
			System.out.println("Usage: PEA <config_file>");
			return;
		}
		
		IParametersImporter ipm = new ParametersFromFile(args[0]);
		ipm.importParameters();
		
		List<Operator> operators = OperatorFactory.getOperatorList(Arrays.asList("Crossover","Mutation","Evaluation","Selection"));
		List<Individual> population = new ArrayList<Individual>();
		for(int i = 0; i < ProblemParameters.population; i++) 
			population.add(new Individual(ProblemParameters.dimensions));
		
		Core c = new Core(ipm, population, operators);
		
		if(ProblemParameters.importProblemParameters(c.parametersImporter) == false)
		{
			return;
		}
		
		c.solve();
	}

}
