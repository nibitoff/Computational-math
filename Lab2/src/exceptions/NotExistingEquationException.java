package exceptions;

public class NotExistingEquationException extends Exception {
    public NotExistingEquationException(String errorMsg){
        super(errorMsg);
    }
}
