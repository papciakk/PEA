package pl.edu.agh.pea.Core;

import pl.edu.agh.pea.Individuals.Individual;
import pl.edu.agh.pea.Operators.OperatorFactory;

import java.io.*;
import java.util.*;

////Core version 1.2

public class Core {	
	static List<Individual> population;
	static OperatorFactory operators;
	
	private static ProblemParameters problemParameters;
	private static IParametersImporter parametersImporter;
	
	public Core(IParametersImporter parametersImporter, ProblemParameters pp){
		Core.parametersImporter = parametersImporter;
		Core.problemParameters = pp;
	}
	
	public static void solve()
	{
		population = new ArrayList<Individual>();
		Individual bestInGeneration;
		
		double [] bestInGenerationArray = new double [problemParameters.generations];
		
		for(int i = 0; i < problemParameters.population; i++) 
			population.add(new Individual(problemParameters));

		operators = new Operators(population, problemParameters);
		
		for(int i = 0; i < problemParameters.generations; i++)
		{
			bestInGeneration = operators.nextGeneration();
			System.out.println("Generation " + i);
			bestInGeneration.printPopulation();
			
			bestInGeneration.updateFitness();
			bestInGenerationArray[i] = bestInGeneration.getFitness();
		}
		
		ChartDrawer.drawPlot(bestInGenerationArray);
	}
	
	public static ProblemParameters getProblemParameters()
	{
		return problemParameters;
	}
	
	
	public static void main(String[] args) {
		
		if(args.length != 1)
		{
			System.out.println("Usage: PEA <config_file>");
			return;
		}
		
		Core c = new Core(new ParametersFromFile(args[0]), new ProblemParameters());
		
		if(getProblemParameters().importProblemParameters(parametersImporter) == false)
		{
			return;
		}
		
		solve();
	}

}
