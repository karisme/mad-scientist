package exceptions;

public class TooMuchMoneyException extends SuspiciousBehaviourException {
    public TooMuchMoneyException(String title, String message) {
        super(title, message);
    }
}
