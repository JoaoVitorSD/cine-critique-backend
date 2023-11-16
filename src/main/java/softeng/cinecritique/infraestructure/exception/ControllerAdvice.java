package softeng.cinecritique.infraestructure.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import softeng.cinecritique.app.domain.exception.ApiException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return new ApiError(errors);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ApiError(ex.getMessage());
    }

    @ExceptionHandler(ApiException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleApiException(ApiException ex) {
        return new ApiError(ex.getMessage());
    }
}
