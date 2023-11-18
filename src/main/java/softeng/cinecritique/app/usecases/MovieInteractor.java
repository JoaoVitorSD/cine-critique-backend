package softeng.cinecritique.app.usecases;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import softeng.cinecritique.app.domain.Genre;
import softeng.cinecritique.app.domain.Movie;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.app.gateway.GenreGateway;
import softeng.cinecritique.app.gateway.MovieGateway;
import java.time.LocalDate;
import java.util.Optional;

public class MovieInteractor {

    MovieGateway movieGateway;

    GenreGateway gateway;

    public MovieInteractor(MovieGateway movieGateway, GenreGateway gateway) {
        this.movieGateway = movieGateway;
        this.gateway = gateway;
    }

    @Transactional
    public Movie createMovie(Movie movie) {
        movie.setCreatedAt(LocalDate.now());
        movie.setGenres(movie.getGenres().stream().map(genre -> {
            Optional<Genre> genreOpt = gateway.findById(genre.getId());
            if(genreOpt.isEmpty()){
                throw new EntityNotFoundException("Genre not found");
            }
            return genreOpt.get();
        }).toList());
        return movieGateway.createMovie(movie);
    }

    public Movie updateMovie(Movie movieUpdated) {
        Optional<Movie> oldMovieOpt = movieGateway.findById(movieUpdated.getId());
        if(oldMovieOpt.isEmpty()){
            throw new EntityNotFoundException("Movie not found");
        }
        Movie movie = oldMovieOpt.get();
        movie.update(movie);
        return movieGateway.updateMovie(movie);
    }

    public PageModel<Movie> getMovies(Integer page, Integer size, String name, String genre) {
        return movieGateway.getMovies(page, size, name, genre);
    }



}
