package numericalMethods;

import exceptions.NotExistingEquationException;
import utils.EquationSystemStorage.AbstractEquationSystem;
import utils.Gauss;

import java.util.Arrays;

import static utils.EquationStorage.getEquationSystems;

public class Newton {

    public static double[] newtonMethod(int equationNumber, double x, double y, double eps) throws NotExistingEquationException {
        double[][] jacoby;
        double[] answers = new double[2];
        double[] differs;
        double[] columns = new double[3];
        AbstractEquationSystem equationSystem = getEquationSystems(equationNumber);
        columns[0] =equationSystem.getFirstEquation(x, y);
        columns[1] =equationSystem.getSecondEquation(x, y);
        double[] temp = {columns[0] + 2 * eps, columns[1] + 2 * eps};
        for (int i = 1; Math.abs(columns[0] - temp[0]) > eps && Math.abs(columns[1] - temp[1]) > eps; i++) {
            temp = Arrays.copyOf(columns, columns.length);
            jacoby = calculateJacoby(temp, equationSystem);
            answers[0] = -equationSystem.getFirstEquation(temp[0], temp[1]);
            answers[1] = -equationSystem.getSecondEquation(temp[0], temp[1]);
            differs = Gauss.getUnknownColumn(jacoby, answers);
            columns[0] += differs[0];
            columns[1] += differs[1];
            columns[2] += i;
        }

        return columns;
    }

    public static double[][] calculateJacoby(double[] columns, AbstractEquationSystem system){
        double[][] jacoby = new double[2][2];
        jacoby[0][0] = system.getDerivativeFirstX(columns[0], columns[1]);
        jacoby[0][1] = system.getDerivativeFirstY(columns[0], columns[1]);
        jacoby[1][0] = system.getDerivativeSecondX(columns[0], columns[1]);
        jacoby[1][1] = system.getDerivativeSecondY(columns[0], columns[1]);
        return jacoby;
    }
}
