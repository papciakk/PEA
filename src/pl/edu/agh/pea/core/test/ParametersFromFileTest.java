package pl.edu.agh.pea.core.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.edu.agh.pea.core.ParametersFromFile;

public class ParametersFromFileTest {

	@Test
	public void test() {
		ParametersFromFile pff = new ParametersFromFile("some_file_name");
		assertEquals("Wrong file name", pff.getFileName(), "some_file_name");
	}

}
