package softeng.cinecritique.app.gateway;

import softeng.cinecritique.app.domain.Genre;
import softeng.cinecritique.app.domain.Movie;
import softeng.cinecritique.app.domain.PageModel;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieGateway {

    Movie createMovie(Movie movie);

    Movie updateMovie(Movie movie);

    PageModel<Movie> getMovies(Integer page, Integer size, String name, String genre);

    void rateMovie(Movie movie, Integer rating);

    Optional<Movie> findById(UUID id);
}
