package pl.edu.agh.pea.Core;

import pl.edu.agh.pea.Individuals.Individual;
import pl.edu.agh.pea.Operators.IOperator;
import pl.edu.agh.pea.Operators.OperatorFactory;

import java.util.*;

////Core version 1.2

public class Core {	
	private static List<Individual> population;
	private List<IOperator> operators;
	private int test;
	
	private IParametersImporter parametersImporter;
	
	public Core(IParametersImporter parametersImporter){
		this.parametersImporter = parametersImporter;
	}
	
	private void solve()
	{
		population = new ArrayList<Individual>();
		for(int i = 0; i < ProblemParameters.population; i++) 
			population.add(new Individual(ProblemParameters.dimensions));
		
		Individual bestInGeneration;
		double [] bestInGenerationArray = new double [ProblemParameters.generations];
		
		for(int i = 0; i < ProblemParameters.generations; i++)
		{
			bestInGeneration = processGeneration();
			System.out.println("Generation " + i);
			bestInGenerationArray[i] = bestInGeneration.getFitness();
			bestInGeneration.printIndividual();
		}
		
		ChartDrawer.drawPlot(bestInGenerationArray);
	}
	
	
	
	private Individual processGeneration(){

		operators = OperatorFactory.getOperatorList(Arrays.asList("Crossover","Mutation","Evaluation","Selection"));
		
		for(IOperator operator: operators){
			operator.setInputPopulation(population);
			operator.execute();
		}
	
		return population.get(0);
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
		
		Core c = new Core(new ParametersFromFile(args[0]));
		
		if(ProblemParameters.importProblemParameters(c.parametersImporter) == false)
		{
			return;
		}
		
		c.solve();
	}

}
