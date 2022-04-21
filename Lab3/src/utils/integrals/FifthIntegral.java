package utils.integrals;

public class FifthIntegral implements IntegralsInterface{
    @Override
    public double getFunction(double x){
        return Math.pow(x, 2);
    }

    @Override
    public double getDerivativeSecond(double x) {
        return 2;
    }
}
