package pl.edu.agh.pea.Core;

//ProblemParameters version 1.0
public class ProblemParameters {
	public int dimensions = -1;
	public int generations = -1;
	public int population = -1;
	
	public double mutationCoefficient = 0.0;
	public double crossCoefficient = 0.0;
	
	//Rastrigin function
	public double ACoefficient = 0.0;
	
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
}
