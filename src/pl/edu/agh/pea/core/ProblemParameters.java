package pl.edu.agh.pea.core;

//ProblemParameters version 1.0
public class ProblemParameters {
	
	private static int dimensions;
	private static int generations;
	private static int population;
	
	private static double mutationCoefficient;
	private static double crossCoefficient;
	
	//Rastrigin function
	private static double ACoefficient;
	
	public static void coefficientsStandarization() throws ArithmeticException {
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

	public static int getDimensions() {
		return dimensions;
	}

	public static int getGenerations() {
		return generations;
	}

	public static int getPopulation() {
		return population;
	}

	public static double getMutationCoefficient() {
		return mutationCoefficient;
	}

	public static double getCrossCoefficient() {
		return crossCoefficient;
	}

	public static double getACoefficient() {
		return ACoefficient;
	}

	public static void setDimensions(int dimensions) {
		ProblemParameters.dimensions = dimensions;
	}

	public static void setGenerations(int generations) {
		ProblemParameters.generations = generations;
	}

	public static void setPopulation(int population) {
		ProblemParameters.population = population;
	}

	public static void setMutationCoefficient(double mutationCoefficient) {
		ProblemParameters.mutationCoefficient = mutationCoefficient;
	}

	public static void setCrossCoefficient(double crossCoefficient) {
		ProblemParameters.crossCoefficient = crossCoefficient;
	}

	public static void setACoefficient(double aCoefficient) {
		ACoefficient = aCoefficient;
	}
}
