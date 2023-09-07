package https.github.com.alecxandy.AutoGestorGURU.ms_user.handler;

import https.github.com.alecxandy.AutoGestorGURU.ms_user.exception.IdentifierNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionhandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        Error error = new Error();
        error.setTimestamp(LocalDateTime.now());
        error.setType(TypeError.URI_ERROR);
        error.setTitle(TypeError.UNAUTHORIZED_FIELD_VALUE);
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setErrosList(errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IdentifierNotFoundException.class)
    public ResponseEntity<?> identifierNotException(IdentifierNotFoundException ex) {
        Error error = new Error();
        error.setType(TypeError.URI_ERROR);
        error.setTitle(TypeError.IDENTIFIER_NOT_FOUND);
        error.setStatus(HttpStatus.NOT_FOUND);
        error.setDetails(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}