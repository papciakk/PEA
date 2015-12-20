package pl.edu.agh.pea.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ParametersFromFile implements IParametersImporter{
	private String fileName;
	
	public ParametersFromFile(String fileName){
		this.fileName = fileName;
	}
	
	public boolean importParameters(){
		return readConfigFile(fileName);
	}
	
	public String getFileName(){
		return fileName;
	}
	
	private boolean readConfigFile(String fileName)
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
				ProblemParameters.setDimensions(val);
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
				ProblemParameters.setGenerations(val);
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
				ProblemParameters.setPopulation(val);
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
				ProblemParameters.setACoefficient(val);
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
				ProblemParameters.setMutationCoefficient(val);
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
				ProblemParameters.setCrossCoefficient(val);
			}
			
			else 
			{
				System.out.println("Unknown parameter on line " + configLineCounter);
				return false;
			}
			
			++configLineCounter;
		}
		
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
		
		ProblemParameters.coefficientsStandarization();
		
		return true;
	}
}