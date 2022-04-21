package utils;

import exceptions.NotExistingEquationException;
import utils.EquationSystemStorage.AbstractEquationSystem;
import utils.EquationSystemStorage.FirstEquation;
import utils.EquationSystemStorage.SecondEquation;
import utils.EquationSystemStorage.ThirdEquation;

public class EquationStorage {
    public static void printEquations() {
        System.out.println("Choose equation: \n" +
                "'1' - 3 * x^2 - 14 * x - 5 = 0 \n" +
                "'2' - (-x^2) + 2 * x + 1 = 0 \n" +
                "'3' - tg(0,7x + 0,02) - x^2  = 0 \n" +
                "'4' - e^(-x) * (1 + x^2)  + sin(x) = 0 \n" +
                "'5' - х^3 – 0,2x^2 + 0,5x + 1,5 = 0");
    }

    public static void printEquationSystems() {
        System.out.println("Choose equation system: \n" +
                "1) sin(x - 0,6) - y = 1,6\n" +
                "   3x - cos(y) = 0,9\n\n" +
                "2) cos(x) + y = 1,5\n" +
                "   2x - sin(y - 0,5) = 1\n\n" +
                "3) x + y^2 = 2\n" +
                "   x^2 + y = 2");
    }

    public static double getEquation(int equationNumber, double x) throws NotExistingEquationException {
        switch (equationNumber) {
            case 1:
                return (3 * Math.pow(x, 2) - 14 * x - 5);
            case 2:
                return -(Math.pow(x, 2) + 2 * x + 1);
            case 3:
                return (Math.tan(0.7 * x + 0.02) - Math.pow(x, 2));
            case 4:
                return (Math.pow(Math.E, -x) * (1 + Math.pow(x, 2)) + Math.sin(x));
            case 5:
                return (Math.pow(x, 3) - 0.2 * (Math.pow(x, 2)) + 0.5 * x + 1.5);
            default:
                throw new NotExistingEquationException("Error! Can't find this equation!");
        }
    }

    public static AbstractEquationSystem getEquationSystems(int number) throws NotExistingEquationException {
        switch (number) {
            case 1:
                return new FirstEquation();
            case 2:
                return new SecondEquation();
            case 3:
                return new ThirdEquation();
            default:
                throw new NotExistingEquationException("ERROR! Can't find this equation system!");
        }
    }
}



