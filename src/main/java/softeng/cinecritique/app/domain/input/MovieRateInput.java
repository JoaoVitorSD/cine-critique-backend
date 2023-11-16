package softeng.cinecritique.app.domain.input;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record MovieRateInput(
        UUID id,

        @NotNull(message = "Movie cannot be null")
        UUID movie,
        @NotNull(message = "User cannot be null")
        UUID user,
        @NotNull(message = "Rate cannot be null")
        @Min(value = 0, message = "Rate must be greater than 0")
        @Max(value = 10, message = "Rate must be less than 10")
        Float rate) {
}

