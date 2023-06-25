package https.github.com.alecxandy.AutoGestorGURU.msprofessor.exception;

public class IdentifierNotFoundException extends RuntimeException{
    public IdentifierNotFoundException() {
        super("Identifier not found");
    }
}
