package hw1;

public class BadOperationException extends Exception {
    
    public BadOperationException(String methodName, String stateName) {
        super("BadOperationException - Can't use " + methodName + " in " + stateName + " state");
    }
}
