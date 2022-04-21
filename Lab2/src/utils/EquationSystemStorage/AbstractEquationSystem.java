package utils.EquationSystemStorage;

public abstract class AbstractEquationSystem {
    public abstract double getFirstEquation(double x, double y);

    public abstract double getSecondEquation(double x, double y);

    public abstract double getDerivativeFirstX(double x, double y);

    public abstract double getDerivativeSecondX(double x, double y);

    public abstract double getDerivativeFirstY(double x, double y);

    public abstract double getDerivativeSecondY(double x, double y);
}
