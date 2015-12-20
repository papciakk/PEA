package pl.edu.agh.pea.core;

//ProblemParameters version 1.0
public class ProblemParameters {
	
	public static int dimensions;
	public static int generations;
	public static int population;
	
	public static double mutationCoefficient;
	public static double crossCoefficient;
	
	//Rastrigin function
	public static double ACoefficient;
	
	public static void coefficientsStandarization() throws ArithmeticException
	{
		double coefficientsSum = mutationCoefficient + crossCoefficient;
		
		if(coefficientsSum == 0.0)
		{
			throw new ArithmeticException("Division by zero");
		}
		
		mutationCoefficient = mutationCoefficient / coefficientsSum;
		crossCoefficient = crossCoefficient / coefficientsSum;
	}
	
	public ProblemParameters(){
		dimensions = -1;
		generations = -1;
		population = -1;
		
		mutationCoefficient = 0.0;
		crossCoefficient = 0.0;
		
		ACoefficient = 0.0;
		coefficientsStandarization();
	}
	
	public static boolean importProblemParameters(IParametersImporter paramsImporter){
		return paramsImporter.importParameters();
	}
}
