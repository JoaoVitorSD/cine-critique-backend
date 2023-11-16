package softeng.cinecritique.infraestructure.controllers.response;


import softeng.cinecritique.app.domain.Movie;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;
import java.util.List;

public record GenreResponse (UUID id, String name, LocalDate createdAt, List<Movie> movies){
}
