package softeng.cinecritique.infraestructure.controllers.response;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record MovieResponse(UUID id, String name, String description, LocalDate filmedAt, List<String> genres, Float rateAvg) {
}
