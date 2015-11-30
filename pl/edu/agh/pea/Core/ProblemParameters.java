package pl.edu.agh.pea.Core;

//ProblemParameters version 1.0
public class ProblemParameters {
	private IParametersImporter parametersImporter;
	
	public int dimensions;
	public int generations;
	public int population;
	
	public double mutationCoefficient;
	public double crossCoefficient;
	
	//Rastrigin function
	public double ACoefficient;
	
	public void coefficientsStandarization() throws ArithmeticException
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
	
	public boolean importProblemParameters(IParametersImporter paramsImporter){
		parametersImporter = paramsImporter;
		return parametersImporter.importParameters(this);
	}
}
