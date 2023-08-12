package https.github.com.alecxandy.AutoGestorGURU.ms_user.exception;


public class IdentifierNotFoundException extends RuntimeException {
    public IdentifierNotFoundException() {
        super("Identifier not found");
    }
}
