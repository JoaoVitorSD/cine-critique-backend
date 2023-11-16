package softeng.cinecritique.app.gateway;

import softeng.cinecritique.app.domain.Movie;

public interface MovieGateway {

    Movie createMovie(Movie movie);

    Movie updateMovie(Movie movie);

//    PageMovie getMovies()
}
