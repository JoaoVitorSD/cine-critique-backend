package softeng.cinecritique.infrastructure.controllers.response;

import java.time.LocalDate;
import java.util.UUID;

public record GenreMovieResponse(UUID id, String name, String description, LocalDate createdAt, Float rateAvg) {
}
