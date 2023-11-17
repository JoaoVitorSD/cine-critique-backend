package softeng.cinecritique.app.domain.exception;

public class ElementNotFoundException extends RuntimeException{
    public ElementNotFoundException(String message) {
        super(message);
    }
}
