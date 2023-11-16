package softeng.cinecritique.infraestructure.controllers.request;

import jakarta.validation.constraints.NotEmpty;
import softeng.cinecritique.app.domain.Movie;

import java.sql.Date;
import java.util.UUID;
import java.util.List;
public record GenreRequest(UUID id,
                           @NotEmpty(message = "Name cannot be empty") String name){
}
