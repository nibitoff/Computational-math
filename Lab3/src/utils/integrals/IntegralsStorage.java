package utils.integrals;

import exceptions.NotExistingIntegralException;

public class IntegralsStorage {
    public static void printIntegrals() {
        System.out.println("Choose integral to calculate: \n" +
                "'1' - 1 / x \n" +
                "'2' - sin(x) / x \n" +
                "'3' - x * (x+1)^(1/2) \n" +
                "'4' - sqrt(x) \n" +
                "'5' - x^2");
    }

    public static IntegralsInterface getIntegral(int num) throws NotExistingIntegralException{
        switch (num){
            case 1:
                return new FirstIntegral();
            case 2:
                return new SecondIntegral();
            case 3:
                return new ThirdIntegral();
            case 4:
                return new FourthIntegral();
            case 5:
                return new FifthIntegral();
            default:
                throw new NotExistingIntegralException();
        }

    }

}
