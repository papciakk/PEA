package pl.edu.agh.pea.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ParametersFromFile implements IParametersImporter{
	private String fileName;
	private Map<String, String> parameters = null;
	
	public ParametersFromFile(String fileName){
		this.fileName = fileName;
	}
	
	public boolean importParameters(){		
		try {
			loadConfigFile();
		} catch (InvalidConfigFileException e) {
			e.printStackTrace();
			return false;
		}
		
		if(loadProblemParameters() == false) { 
			return false;
		}
		
		ProblemParameters.coefficientsStandarization();
		
		if(ProblemParameters.checkParametersCorrectness() == false) {
			return false;
		}
		
		return true;
	}
	
	public String getFileName(){
		return fileName;
	}
	
	private String [] readConfigFile() throws InvalidConfigFileException{
		BufferedReader br = null;
		List<String> configFile = new LinkedList<>();
		String sCurrentLine;
		
		try {
			br = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			throw new InvalidConfigFileException("File \"" + fileName + "\" cannot be found or open");
		}
		
		try {
			while ((sCurrentLine = br.readLine()) != null) {
				configFile.add(sCurrentLine);
			}
			br.close();
		} catch (IOException e) {
			throw new InvalidConfigFileException("Error while reading \"" + fileName + "\" file");
		}

		return  configFile.toArray(new String[configFile.size()]);
	}
	
	private Map<String, String> loadParametersFromConfigFile(String [] configFile) throws InvalidConfigFileException {
		String s;
		Map<String, String> parameters = new LinkedHashMap<>();
		
		for(int i = 0; i < configFile.length; ++i){
			s = configFile[i];
			
			if(s.length() == 1){
				throw new InvalidConfigFileException("Syntax error in config file on line " + i);		
			}
			if(s.length() == 0 || (s.charAt(0) == '/' && s.charAt(1) == '/')){
				++i;
				continue;
			}
			if(s.split("=").length < 2){
				throw new InvalidConfigFileException("Syntax error in config file on line " + i);
			}
			
			String param = s.split("=")[0];
			String value = s.split("=")[1];
			
			parameters.put(param,  value);
		}
		
		return parameters;
	}
	
	private boolean loadProblemParameters()
	{
		if(parameters == null){
			throw new NullPointerException();
		}
		
		try {
			ProblemParameters.setACoefficient(Integer.parseInt(parameters.get("A_COEFF")));
		}
		catch(NumberFormatException e) {
			System.out.println("Not a valid value for A_COEFF");
			return false;
		}
		
		try{
			ProblemParameters.setDimensions(Integer.parseInt(parameters.get("DIMENSIONS")));
		}
		catch(NumberFormatException e){
			System.out.println("Not a valid value for DIMENSIONS");
			return false;
		}
		
		try{
			ProblemParameters.setGenerations(Integer.parseInt(parameters.get("GENERATIONS")));
		}
		catch(NumberFormatException e){
			System.out.println("Not a valid value for GENERATIONS");
			return false;
		}
		
		try{
			ProblemParameters.setPopulation(Integer.parseInt(parameters.get("POPULATION")));
		}
		catch(NumberFormatException e){
			System.out.println("Not a valid value for POPULATION");
			return false;
		}
		
		try{
			ProblemParameters.setCrossCoefficient(Double.parseDouble(parameters.get("CROSS_COEFF")));
		}
		catch(NumberFormatException e){
			System.out.println("Not a valid value for CROSS_COEFF");
			return false;
		}
		
		try{
			ProblemParameters.setCrossCoefficient(Double.parseDouble(parameters.get("MUTATIONS_COEFF")));
		}
		catch(NumberFormatException e){
			System.out.println("Not a valid value for MUTATIONS_COEFF");
			return false;
		}
		
		return true;
	}
	
	private void loadConfigFile() throws InvalidConfigFileException
	{
		String [] configFile;
		
		try {
			configFile = readConfigFile();
		}catch(InvalidConfigFileException e){
			throw e;
		}
		
		try {
			parameters = loadParametersFromConfigFile(configFile);
		} catch (InvalidConfigFileException e) {
			throw e;
		}
	}
}