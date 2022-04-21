package exceptions;

public class NotDefinedFunctionException extends Exception {
    public NotDefinedFunctionException(){
        super("Error! This function is not defined!");
    }
}
