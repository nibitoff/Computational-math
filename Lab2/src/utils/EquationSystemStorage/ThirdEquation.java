package utils.EquationSystemStorage;

public class ThirdEquation extends AbstractEquationSystem{
    @Override
    public double getFirstEquation(double x, double y) {
        return x + Math.pow(y, 2) - 2;
    }
    @Override
    public double getSecondEquation(double x, double y) {
        return Math.pow(x, 2) + y - 2;
    }
    @Override
    public double getDerivativeFirstX(double x, double y) {
        return 1;
    }
    @Override
    public double getDerivativeSecondX(double x, double y) {
        return 2 * x;
    }
    @Override
    public double getDerivativeFirstY(double x, double y) {
        return 2 * y;
    }
    @Override
    public double getDerivativeSecondY(double x, double y) {
        return 1;
    }
}
