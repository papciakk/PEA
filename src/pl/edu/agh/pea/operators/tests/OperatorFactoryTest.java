package pl.edu.agh.pea.operators.tests;

import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.pea.operators.Operator;
import pl.edu.agh.pea.operators.OperatorFactory;
import pl.edu.agh.pea.operators.implementation.Crossover;
import pl.edu.agh.pea.operators.implementation.Evaluation;
import pl.edu.agh.pea.operators.implementation.Mutation;
import pl.edu.agh.pea.operators.implementation.Selection;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class OperatorFactoryTest {

    private List<Operator> ops1;
    private List<String> names;

    @Before
    public  void init() {
        names = Arrays.asList("Crossover", "Mutation", "Evaluation", "Selection");
        ops1 = OperatorFactory.getOperatorList(names);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetOperatorListIllegalName() {
        OperatorFactory.getOperatorList(
                Arrays.asList("Crossover", "WrongName", "Evaluation", "Selection")
        );
    }

    @Test
    public void testSingletons() {
        boolean sameInstances = true;

        List<Operator> ops2 = OperatorFactory.getOperatorList(names);

        for (int i = 0; i < ops1.size(); i++) {
            if (ops1.get(i) != ops2.get(i)) {
                sameInstances = false;
                break;
            }
        }

        assertTrue("Operator singletons works: ", sameInstances);
    }

    @Test
    public void testOperatorsOrder() {
        assertTrue("Is crossover operator: ", ops1.get(0) instanceof Crossover);
        assertTrue("Is mutation operator: ", ops1.get(1) instanceof Mutation);
        assertTrue("Is evaluation operator: ", ops1.get(2) instanceof Evaluation);
        assertTrue("Is selection operator: ", ops1.get(3) instanceof Selection);
    }
}
