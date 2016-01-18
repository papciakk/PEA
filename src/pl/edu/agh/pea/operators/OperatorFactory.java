package pl.edu.agh.pea.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperatorFactory {

    private static final Logger LOG = Logger.getLogger(OperatorFactory.class.getName());
    private static final String pkg_name = "pl.edu.agh.pea.operators.implementation.";

    private static Map<String, Operator> operators = new HashMap<>();

    private OperatorFactory() {
    }

    public static List<Operator> getOperatorList(List<String> operatorNames) {
        List<Operator> ops = new ArrayList<>();
        Operator op;

        try {
            for (String opName : operatorNames) {
                if (!operators.containsKey(opName)) {
                    op = (Operator) Class.forName(pkg_name + opName).newInstance();
                } else {
                    op = operators.get(opName);
                }

                ops.add(op);
            }
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            LOG.log(Level.SEVERE, e.toString(), e);
        }

        return ops;
    }
}
