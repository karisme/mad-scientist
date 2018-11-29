package exceptions;

public class YouAreBrokeException extends SuspiciousBehaviourException {
    public YouAreBrokeException(String title, String message) {
        super(title, message);
    }
}
