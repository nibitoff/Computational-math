package utils.EquationSystemStorage;

public class SecondEquation extends AbstractEquationSystem {
    @Override
    public double getFirstEquation(double x, double y) {
        return Math.cos(x) + y - 1.5;
    }
    @Override
    public double getSecondEquation(double x, double y) {
        return 2 * x - Math.sin(y - 0.5) - 1;
    }
    @Override
    public double getDerivativeFirstX(double x, double y) {
        return -Math.sin(x);
    }
    @Override
    public double getDerivativeSecondX(double x, double y) {
        return 2;
    }
    @Override
    public double getDerivativeFirstY(double x, double y) {
        return 1;
    }
    @Override
    public double getDerivativeSecondY(double x, double y) {
        return -Math.cos(y - 0.5);
    }
}
