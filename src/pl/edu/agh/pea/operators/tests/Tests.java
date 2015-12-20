package pl.edu.agh.pea.operators.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import pl.edu.agh.pea.core.ProblemParameters;
import pl.edu.agh.pea.operators.OperatorFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Tests {

    private static final Logger LOG = Logger.getLogger(OperatorFactory.class.getName());

    private Tests() {
    }

    public static void init() {
        initProblemParameters();
    }

    public static void initProblemParameters() {
        ProblemParameters.setDimensions(20);
        ProblemParameters.setGenerations(20);
        ProblemParameters.setPopulation(50);
        ProblemParameters.setMutationCoefficient(1.0);
        ProblemParameters.setCrossCoefficient(1.0);
        ProblemParameters.setACoefficient(10.0);
    }

    public static void main(String[] argv) {
        Result result;
        boolean globalResult = true;

        init();

        Class[] testClasses = {
                OperatorTest.class, OperatorFactoryTest.class,
                CrossoverTest.class, MutationTest.class,
                EvaluationTest.class, IndividualComparatorTest.class,
                SelectionTest.class
        };

        String testName;
        for (int i = 0; i < testClasses.length; i++) {
            testName = i + ". " + testClasses[i].getName() + " Test: ";

            result = JUnitCore.runClasses(testClasses[i]);
            for (Failure failure : result.getFailures()) {
                LOG.log(Level.SEVERE, failure.toString());
            }
            LOG.log(Level.INFO, testName + result.wasSuccessful());
            globalResult &= result.wasSuccessful();
        }

        LOG.log(Level.INFO, "All tests passed: " + globalResult);
    }
}
