package mathMethods;

import exceptions.IrremovableGapException;
import exceptions.NotDefinedFunctionException;
import exceptions.NotExistingIntegralException;
import utils.integrals.IntegralsInterface;
import utils.integrals.IntegralsStorage;

public class TrapezoidMethod {
    public static double[] trapezoidMethod(int number, double[] borders, double eps) throws NotExistingIntegralException, IrremovableGapException, NotDefinedFunctionException {
        double[] answer = new double[2];
        IntegralsInterface integral = IntegralsStorage.getIntegral(number);
        checkIsFunctionDefined(integral, borders[0]);
        double maxSegmentValue = getDerivativeSecondMax(borders, integral);
        int n = getSegmentsAmount(borders, eps, maxSegmentValue);
        double h = (borders[1] - borders[0]) / n;
        double x0 = borders[0];
        double x1;
        double y0, y1;
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            x1 = x0 + h;
            y0 = integral.getFunction(x0);
            y1 = integral.getFunction(x1);

            if (Math.abs(x1) < 0.001) {
                x0 = 0;
            }

            if (checkGaps(integral, x0)) {
                x0 += 0.001;
                continue;
            }

            sum += (y0 + y1) * (x1 - x0) / 2;
            x0 += h;
    }
        answer[0] = sum;
        answer[1] = n;
        return answer;
    }


    private static double getDerivativeSecondMax(double[] borders, IntegralsInterface integral){
            Double max = Math.abs(integral.getDerivativeSecond(borders[0]));
        if(max.isInfinite()){
            max = Math.abs(integral.getDerivativeSecond(borders[0] + 0.01));
        }
        double x = borders[0];
        while (x < borders[1]){
            if (Math.abs(x - 0) < 0.0001){
                x = 0;
            }
            if (x == borders[0]){
                x += 0.1;
                continue;
            }
            if (Double.isInfinite(integral.getDerivativeSecond(x)) || Double.isNaN(integral.getDerivativeSecond(x))){
                x += 0.1;
                continue;
            }
            if (Math.abs(integral.getDerivativeSecond(x)) > max){
                max = Math.abs(integral.getDerivativeSecond(x));
            }
            x += 0.1;
        }
        return max;
    }

    /*
    private static double getError(IntegralsInterface integral, double maxSegmentValue, double[] borders, int n){
         return Math.abs(integral.getDerivativeSecond(maxSegmentValue)) * Math.pow(borders[1] - borders[0], 3) / (12 * Math.pow(n, 2));
    }

     */
    private static void checkIsFunctionDefined(IntegralsInterface integral, double x) throws NotDefinedFunctionException{
        Double a = integral.getFunction(x);
        if (a.isNaN()){
            Double left = integral.getFunction(x - 0.00001);
            Double right = integral.getFunction(x + 0.00001);
            if (left.isNaN() || right.isNaN()){
                throw new NotDefinedFunctionException();
            }
        }
    }
    private static boolean checkGapIsDisposable(IntegralsInterface integral, double x) throws IrremovableGapException {
        Double left = integral.getFunction(x + 0.0000001);
        Double right = integral.getFunction(x - 0.0000001);
        System.out.println("\nBreak point is " + x);
        if (Math.abs(right - left) < 0.001){
            System.out.println("The limits converge. This is a disposable gap of the 1st kind.");
            return true;
        }else {
            throw new IrremovableGapException(x, 1);
        }
    }
    private static boolean checkGaps(IntegralsInterface integral, double x) throws IrremovableGapException{
        Double a = integral.getFunction(x);
        if (a.isInfinite()){
            throw new IrremovableGapException(x, 2);
        }
        if (a.isNaN()) {
            return checkGapIsDisposable(integral, x);
        }
        return false;
    }

    private static int getSegmentsAmount(double[] borders, double eps, double DerivativeSecondMax) throws IrremovableGapException {
        double result = Math.sqrt ((DerivativeSecondMax * Math.pow((borders[1] - borders[0]), 3)) / (12 * eps));
        if (Math.abs(result) == 0){
            throw new IrremovableGapException(0, 1);
        }
        if (Math.abs(result - (int) result) < 0.000001){
            return (int) result;
        }
        else{
            return (int) result + 1;
        }
    }

}
