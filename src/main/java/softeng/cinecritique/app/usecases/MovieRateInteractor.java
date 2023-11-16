package softeng.cinecritique.app.usecases;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import softeng.cinecritique.app.domain.Genre;
import softeng.cinecritique.app.domain.Movie;
import softeng.cinecritique.app.domain.MovieRate;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.app.domain.exception.ApiException;
import softeng.cinecritique.app.domain.exception.ElementNotFoundException;
import softeng.cinecritique.app.gateway.GenreGateway;
import softeng.cinecritique.app.gateway.MovieGateway;
import softeng.cinecritique.app.gateway.MovieRateGateway;

import java.time.LocalDate;
import java.util.Optional;

public class MovieRateInteractor {

    MovieGateway movieGateway;

    MovieRateGateway movieRateGateway;



    public MovieRate rateMovie(MovieRate movieRate) {
        if(movieRate.getRate()<=0){
            throw new ApiException("Rate must be greater or equal than 0");
        }
        if(movieGateway.findById(movieRate.getMovie().getId()).isEmpty()){
            throw new ElementNotFoundException("Movie not found");
        }
        return movieRateGateway.rateMovie(movieRate);
    }

    public MovieRate updateRate(MovieRate rateUpdated) {
        Optional<MovieRate> oldMovieOpt = movieRateGateway.findById(rateUpdated.getId());
        if(oldMovieOpt.isEmpty()){
            throw new ElementNotFoundException("Movie not found");
        }
        MovieRate rate = oldMovieOpt.get();
        rate.update(rate);
        return movieRateGateway.updateRate(rate);
    }

    public PageModel<Movie> getMovies(Integer page, Integer size, String name, String genre) {
        return movieGateway.getMovies(page, size, name, genre);
    }



}
