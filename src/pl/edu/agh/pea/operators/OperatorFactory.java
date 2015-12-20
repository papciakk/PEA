package pl.edu.agh.pea.operators;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import pl.edu.agh.pea.operators.implementation.Crossover;
import pl.edu.agh.pea.operators.implementation.Evaluation;
import pl.edu.agh.pea.operators.implementation.Mutation;
import pl.edu.agh.pea.operators.implementation.Selection;

public class OperatorFactory {

    private static final Logger LOG = Logger.getLogger(OperatorFactory.class.getName());

    private static Crossover crossoverOperator = null;
    private static Evaluation evaluationOperator = null;
    private static Mutation mutationOperator = null;
    private static Selection selectionOperator = null;

    private OperatorFactory() {
    }

    /**
     * @return Returns crossover operator instance
     */
    public static Crossover getCrossoverOperatorInstance() {
        if (crossoverOperator == null) {
            crossoverOperator = new Crossover();
        }
        return crossoverOperator;
    }

    /**
     * @return Returns evaluation operator instance
     */
    public static Evaluation getEvaluationOperatorInstance() {
        if (evaluationOperator == null) {
            evaluationOperator = new Evaluation();
        }
        return evaluationOperator;
    }

    /**
     * @return Returns mutation operator instance
     */
    public static Mutation getMutationOperatorInstance() {
        if (mutationOperator == null) {
            mutationOperator = new Mutation();
        }
        return mutationOperator;
    }

    /**
     * @return Returns selection operator instance
     */
    public static Selection getSelectionOperatorInstance() {
        if (selectionOperator == null) {
            selectionOperator = new Selection();
        }
        return selectionOperator;
    }

    /**
     * @param operatorNames operator names with given order
     * @return Returns list of operators in order given by list of strings
     */
    public static List<Operator> getOperatorList(List<String> operatorNames) {
        String methodName;
        List<Operator> operators = new ArrayList<>();

        ArrayList<String> methodNames = getMethodNames();

        for (String opName : operatorNames) {
            methodName = "get" + opName + "OperatorInstance";
            if(!methodNames.contains(methodName)) {
                throw new IllegalArgumentException("Illegal operator name: " + opName);
            }
            else {
                operators.add(getOperator(methodName));
            }
        }

        return operators;
    }

    private static ArrayList<String> getMethodNames() {
        ArrayList<String> methodNames = new ArrayList<>();
        for(Method m : OperatorFactory.class.getMethods()) {
            methodNames.add(m.getName());
        }
        return methodNames;
    }

    private static Operator getOperator(String methodName) {
        Method getInstance;
        Operator operator = null;

        try {
            getInstance = OperatorFactory.class.getMethod(methodName);
            operator = (Operator) getInstance.invoke(OperatorFactory.class);
        } catch (NoSuchMethodException | SecurityException |
                InvocationTargetException | IllegalAccessException e) {
            LOG.log(Level.SEVERE, e.toString(), e);
        }

        return operator;
    }
}