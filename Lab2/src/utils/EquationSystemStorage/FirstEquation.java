package utils.EquationSystemStorage;

public class FirstEquation extends AbstractEquationSystem {
    @Override
    public double getFirstEquation(double x, double y) {
        return Math.sin(x - 0.6) - y - 1.6;
    }
    @Override
    public double getSecondEquation(double x, double y) {
        return 3 * x - Math.cos(y) - 0.9;
    }
    @Override
    public double getDerivativeFirstX(double x, double y) {
        return Math.cos(x - 0.6);
    }
    @Override
    public double getDerivativeSecondX(double x, double y) {
        return 3;
    }
    @Override
    public double getDerivativeFirstY(double x, double y) {
        return -1;
    }
    @Override
    public double getDerivativeSecondY(double x, double y) {
        return Math.sin(y);
    }
}
