package numericalMethods;

import exceptions.NotExistingEquationException;

import static utils.EquationStorage.getEquation;

public class Chord {
    public static double chordMethod(double a, double b, double eps, int equation) throws NotExistingEquationException {
        checkIntervalArguments(a, b, equation);
        double temp;
        double diff = 1;
        double c = 0;
        while (Math.abs(diff) > eps){
            if (getEquation(equation, a) * getEquation(equation, makeNextValue(a, b, equation)) < 0) {
                temp = b;
                b = makeNextValue(a, b, equation);
                diff = temp - b;
                c = b;
            } else {
                temp = a;
                a = makeNextValue(a, b, equation);
                diff = temp - a;
                c = a;
            }
        }
        return c;
        }


    private static void checkIntervalArguments(double a, double b, int equation) throws NotExistingEquationException {
        if (getEquation(equation, a) * getEquation(equation, b) > 0){
            System.err.println("ERROR! The intervals have the same sign!");
            System.exit(1);
        }
    }

    private static double makeNextValue(double a, double b, int equation) throws NotExistingEquationException {
       return (a - ((b - a) / (getEquation(equation, b) - getEquation(equation, a))) * getEquation(equation, a));
    }
}
