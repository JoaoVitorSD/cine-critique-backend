package softeng.cinecritique.infrastructure.controllers.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.time.LocalDate;
import java.util.UUID;

public record MovieRequest(UUID id,
                           @NotEmpty(message = "Name cannot be empty") String name,
                            @NotEmpty(message = "Description cannot be empty") String description,
                            @NotNull(message = "Filmed at cannot be empty") LocalDate filmedAt,
                           @NotNull(message = "Genres cannot be empty")
                           @Size(min = 1, message = "Movie must have at least one genre")
                           List<UUID> genres
){
}
