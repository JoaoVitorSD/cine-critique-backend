package softeng.cinecritique.infrastructure.controllers.request;

import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public record GenreRequest(UUID id,
                           @NotEmpty(message = "Name cannot be empty") String name){
}
