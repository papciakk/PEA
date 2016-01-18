package pl.edu.agh.pea.core;

@SuppressWarnings("serial")
public class InvalidConfigFileException extends Exception {

	InvalidConfigFileException(String errorMessage){
		super(errorMessage);
	}
}
