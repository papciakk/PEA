package pl.edu.agh.pea.core;

//ProblemParameters version 1.0
public class ProblemParameters {
	
	private static int dimensions;
	private static int generations;
	private static int population;
	private static int islands;
	
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
	
	public static boolean checkParametersCorrectness() {
		if(ProblemParameters.getMutationCoefficient() + ProblemParameters.getCrossCoefficient() == 0.0)
		{
			System.out.println("Mutation Coefficient + Cross Coefficient must be greater than zero");
			return false;
		}
		
		if(ProblemParameters.getMutationCoefficient() < 0.0 || ProblemParameters.getCrossCoefficient() < 0.0)
		{
			System.out.println("Mutation Coefficient and Cross Coefficient must be greater or equal zero each");
			return false;
		}
		
		if(ProblemParameters.getDimensions() < 0)
		{
			System.out.println("Dimensions parameter not given or invalid (should be greater than 0)");
			return false;
		}
		
		if(ProblemParameters.getGenerations() < 0)
		{
			System.out.println("Generations parameter not given or invalid (should be greater than 0)");
			return false;
		}
		
		if(ProblemParameters.getPopulation() < 0)
		{
			System.out.println("Population parameter not given or invalid (should be greater than 0)");
			return false;
		}
		
		return true;
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
	
	public static int getIslands() {
		return islands;
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
	
	public static void setIslands(int islands) {
		ProblemParameters.islands = islands;
	}
}
