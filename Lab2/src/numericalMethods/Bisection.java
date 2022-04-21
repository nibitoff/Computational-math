package numericalMethods;
import exceptions.NotExistingEquationException;

import static utils.EquationStorage.*;

public class Bisection {
    public static double bisectionMethod(double a, double b, double eps, int equation) throws NotExistingEquationException {
        checkIntervalArguments(a, b, equation);
        double c;
        while (b - a > eps){
            c = (a + b) / 2;
            if (getEquation(equation, a) * getEquation(equation, c) < 0){
                b = c;
            }else if (getEquation(equation, a) * getEquation(equation, c) > 0){
                a = c;
            }else{
                return a;
            }
         }
        return a;
    }

    private static void checkIntervalArguments(double a, double b, int equation) throws NotExistingEquationException {
        if (getEquation(equation, a) * getEquation(equation, b) > 0){
            System.err.println("ERROR! The intervals have the same sign!");
            System.exit(1);
        }
    }

}
