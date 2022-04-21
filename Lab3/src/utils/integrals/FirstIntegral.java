package utils.integrals;

public class FirstIntegral implements IntegralsInterface{

    @Override
    public double getFunction(double x){
        return (1 / x);
    }

    @Override
    public double getDerivativeSecond(double x) {
        return (2 / Math.pow(x, 3));
    }

}
