package https.github.com.alecxandy.AutoGestor.git.ms_vehicle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Indentificador não encontrado")
public class IdentifierNotFoundException extends RuntimeException {

    public IdentifierNotFoundException() {
        super("Identifier not found");
    }
}
