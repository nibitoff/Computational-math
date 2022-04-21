package utils.integrals;

public class FourthIntegral implements IntegralsInterface {
    @Override
    public double getFunction(double x){
        return Math.sqrt(x);
    }

    @Override
    public double getDerivativeSecond(double x) {
        return (-1/(4 * Math.pow(x, 3.0 / 2.0)));
    }
}
