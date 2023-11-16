package softeng.cinecritique.app.gateway;

import softeng.cinecritique.app.domain.MovieRate;
import softeng.cinecritique.app.domain.PageModel;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

public interface MovieRateGateway {

    MovieRate rateMovie(MovieRate rate);

    MovieRate updateRate(MovieRate rate);

    List<MovieRate> getRates(UUID move, UUID user);


    Optional<MovieRate> findById(UUID id);
}
