package pl.edu.agh.pea.core;

import pl.edu.agh.pea.individuals.Individual;
import pl.edu.agh.pea.individuals.Island;
import pl.edu.agh.pea.operators.Operator;
import pl.edu.agh.pea.operators.OperatorFactory;
import pl.edu.agh.pea.operators.implementation.IndividualComparator;

import java.util.*;

public class Core {	
	private List<Island> population;
	private List<Operator> operators;
	
<<<<<<< HEAD
	private IParametersImporter parametersImporter;
	
	public Core(IParametersImporter parametersImporter, List<Island> population, List<Operator> operators){
		this.parametersImporter = parametersImporter;
=======
	public Core(List<Individual> population, List<Operator> operators){
>>>>>>> 3987ad69aba1efab0d52a78c327ff72e99d6f390
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
<<<<<<< HEAD
			bestInGeneration.toString();
			if((i+1)%10 == 0){
				migrate(population);
			}
=======
			System.out.println(bestInGeneration);
>>>>>>> 3987ad69aba1efab0d52a78c327ff72e99d6f390
		}
		
		ChartDrawer.drawPlot(bestInGenerationArray);
	}
	
	public Individual getBestIndividual(){
		IndividualComparator comparator = new IndividualComparator();
		PriorityQueue<Individual> bestFromIslands = new PriorityQueue<>(comparator);
		for(Island island : population){
			bestFromIslands.add(island.getPopulation().get(0));
		}
		return bestFromIslands.poll();
	}
	
	private Individual processGeneration(){

		for(Island island : population){
			for(Operator operator: operators){
				operator.setInputPopulation(island);
				operator.execute();
			}
		}
	
		return getBestIndividual();
	}
	
	public void migrate(List<Island> population){
		List<Individual> emigrants = new ArrayList<Individual>();
		List<Individual> immigrants = new ArrayList<Individual>();
		immigrants = population.get(ProblemParameters.getIslands()-1).emigrate(5); //emigrants from last island
		emigrants = null;
		for(int i=0; i<ProblemParameters.getIslands(); i++){
			if(emigrants != null){
				immigrants = emigrants;
			}
			if(i != ProblemParameters.getIslands()-1) {
				emigrants = population.get(i).emigrate(5);
			}
			population.get(i).immigrate(immigrants); 
		}
		
	}
	
	public List<Island> getPopulation(){
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
		List<Island> population = new ArrayList<Island>();
		List<Individual> islandPopulation = new ArrayList<Individual>();
		for(int i = 0; i < ProblemParameters.getIslands(); i++){
			islandPopulation.clear();
			for(int j = 0; j < ProblemParameters.getPopulation(); j++) {
				islandPopulation.add(new Individual(ProblemParameters.getDimensions()));
			}
			Island island = new Island();
			island.setPopulation(islandPopulation);
			population.add(island);
		}
			
		Core c = new Core(population, operators);
		
		c.solve();
	}

}
