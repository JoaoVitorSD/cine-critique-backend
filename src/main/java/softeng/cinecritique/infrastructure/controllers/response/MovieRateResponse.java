package softeng.cinecritique.infrastructure.controllers.response;

import java.util.UUID;

public record  MovieRateResponse(UUID id,String movie, Float rate, String username) {
}
