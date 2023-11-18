package softeng.cinecritique.infrastructure.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ApiError {
    private List<String> error;

    public ApiError(List<String> errors) {
        this.error = errors;
    }
    public ApiError(String messageErrors) {
        this.error = Arrays.asList(messageErrors);
    }
}
