package pl.edu.agh.pea.Core;

import pl.edu.agh.pea.Individuals.Individual;
import pl.edu.agh.pea.Operators.Operators;

import java.io.*;
import java.util.*;

////Core version 1.2

public class Core {
	private static ProblemParameters problemParameters = new ProblemParameters();
	
	static List<Individual> population;
	static Operators operators;
	
	public static boolean readConfigFile(String fileName)
	{
		BufferedReader br = null;
		List<String> configFile = new LinkedList<String>();
		int configLineCounter = 1;
		
		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(fileName));

			while ((sCurrentLine = br.readLine()) != null) {
				configFile.add(sCurrentLine);
			}

		} catch (IOException e) {
			System.out.println("File \"" + fileName + "\" cannot be found or open");
		} finally {
			try {
				if (br != null) br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				return false;
			}
		}
		
		for(String s : configFile)
		{
			if(s.length() == 1)
			{
				System.out.println("Syntax error in config file on line " + configLineCounter);
				return false;			
			}
			if(s.length() == 0 || (s.charAt(0) == '/' && s.charAt(1) == '/'))
			{
				++configLineCounter;
				continue;
			}
			if(s.split("=").length < 2)
			{
				System.out.println("Syntax error in config file on line " + configLineCounter);
				return false;
			}
			
			String param = s.split("=")[0];
			String value = s.split("=")[1];
			if(param.equals("DIMENSIONS"))
			{
				int val;
				try
				{
					val = Integer.parseInt(value);
				}
				catch(NumberFormatException e)
				{
					System.out.println("Not a valid value on line " + configLineCounter);
					return false;
				}
				problemParameters.dimensions = val;
			} else if(param.equals("GENERATIONS"))
			{
				int val;
				try
				{
					val = Integer.parseInt(value);
				}
				catch(NumberFormatException e)
				{
					System.out.println("Not a valid value on line " + configLineCounter);
					return false;
				}
				problemParameters.generations = val;
			} else if(param.equals("POPULATION"))
			{
				int val;
				try
				{
					val = Integer.parseInt(value);
				}
				catch(NumberFormatException e)
				{
					System.out.println("Not a valid value on line " + configLineCounter);
					return false;
				}
				problemParameters.population = val;
			} else if(param.equals("A_COEFF"))
			{
				int val;
				try
				{
					val = Integer.parseInt(value);
				}
				catch(NumberFormatException e)
				{
					System.out.println("Not a valid value on line " + configLineCounter);
					return false;
				}
				problemParameters.ACoefficient = val;
			} 	
			else if(param.equals("MUTATIONS_COEFF"))
			{
				double val;
				try
				{
					val = Double.parseDouble(value);
				}
				catch(NumberFormatException e)
				{
					System.out.println("Not a valid value on line " + configLineCounter);
					return false;
				}
				problemParameters.mutationCoefficient = val;
			} else if(param.equals("CROSS_COEFF"))
			{
				double val;
				try
				{
					val = Double.parseDouble(value);
				}
				catch(NumberFormatException e)
				{
					System.out.println("Not a valid value on line " + configLineCounter);
					return false;
				}
				problemParameters.crossCoefficient = val;
			}
			
			else 
			{
				System.out.println("Unknown parameter on line " + configLineCounter);
				return false;
			}
			
			++configLineCounter;
		}
		
		if(problemParameters.mutationCoefficient + problemParameters.crossCoefficient == 0.0)
		{
			System.out.println("Mutation Coefficient + Cross Coefficient must be greater than zero");
			return false;
		}
		
		if(problemParameters.mutationCoefficient < 0.0 || problemParameters.crossCoefficient < 0.0)
		{
			System.out.println("Mutation Coefficient and Cross Coefficient must be greater or equal zero each");
			return false;
		}
		
		if(problemParameters.dimensions < 0)
		{
			System.out.println("Dimensions parameter not given or invalid (should be greater than 0)");
			return false;
		}
		
		if(problemParameters.generations < 0)
		{
			System.out.println("Generations parameter not given or invalid (should be greater than 0)");
			return false;
		}
		
		if(problemParameters.population < 0)
		{
			System.out.println("Population parameter not given or invalid (should be greater than 0)");
			return false;
		}
		
		problemParameters.coefficientsStandarization();
		
		return true;
	}

	public static void solve()
	{
		population = new ArrayList<Individual>();
		Individual bestInGeneration;
		
		double [] bestInGenerationArray = new double [problemParameters.generations];
		int [] generations = new int [problemParameters.generations];
		
		for(int i = 0; i < problemParameters.population; i++) 
			population.add(new Individual(problemParameters, true));

		operators = new Operators(population, problemParameters);
		
		for(int i = 0; i < problemParameters.generations; i++)
		{
			bestInGeneration = operators.nextGeneration();
			System.out.println("Generation " + i);
			bestInGeneration.printPopulation();
			
			bestInGeneration.updateFitness();
			bestInGenerationArray[i] = bestInGeneration.getFitness();
			generations[i] = i;
		}
		
		ChartDrawer.drawPlot(generations, bestInGenerationArray);
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
		
		if(readConfigFile(args[0]) == false)
		{
			return;
		}
		
		solve();
	}

}
