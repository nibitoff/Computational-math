package exceptions;

public class NotExistingIntegralException extends Exception {
    public NotExistingIntegralException(){
        super("ERROR! Can't find this integral!");
    }
}

