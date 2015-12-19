package pl.edu.agh.pea.Core.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import pl.edu.agh.pea.Core.ParametersFromFile;

public class ParametersFromFileTest {

	@Test
	public void test() {
		ParametersFromFile pff = new ParametersFromFile("some_file_name");
		assertEquals("Wrong file name", pff.getFileName(), "some_file_name");
	}

}
