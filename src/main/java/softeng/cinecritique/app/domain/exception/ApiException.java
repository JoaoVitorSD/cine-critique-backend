package softeng.cinecritique.app.domain.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message) {
        super(message);
    }
}
