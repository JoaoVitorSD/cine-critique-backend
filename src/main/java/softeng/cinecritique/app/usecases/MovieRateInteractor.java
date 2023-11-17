package softeng.cinecritique.app.usecases;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import softeng.cinecritique.app.domain.Genre;
import softeng.cinecritique.app.domain.Movie;
import softeng.cinecritique.app.domain.MovieRate;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.app.domain.exception.ApiException;
import softeng.cinecritique.app.domain.exception.ElementNotFoundException;
import softeng.cinecritique.app.domain.input.MovieRateInput;
import softeng.cinecritique.app.gateway.GenreGateway;
import softeng.cinecritique.app.gateway.MovieGateway;
import softeng.cinecritique.app.gateway.MovieRateGateway;
import softeng.cinecritique.app.gateway.UserGateway;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

public class MovieRateInteractor {

    MovieGateway movieGateway;

    UserGateway userGateway;

    MovieRateGateway movieRateGateway;

    public MovieRateInteractor(MovieGateway movieGateway, UserGateway userGateway, MovieRateGateway movieRateGateway) {
        this.movieGateway = movieGateway;
        this.userGateway = userGateway;
        this.movieRateGateway = movieRateGateway;
    }

    private MovieRate toModel(MovieRateInput input){
        MovieRate movieRate = new MovieRate();
        movieRate.setId(input.id());
        movieRate.setRate(input.rate());

        movieRate.setMovie(
                movieGateway.
                        findById(input.movie())
                        .orElseThrow(()-> new ElementNotFoundException("Movie not found")));
        movieRate.setUser(userGateway
                .findById(input.user())
                .orElseThrow(()-> new ElementNotFoundException("User not found")));
        System.out.println("Aqui passou " +  movieRate.getMovie().getName());
        return movieRate;
    }


    public MovieRate rateMovie(MovieRateInput input)  {
        MovieRate rate = toModel(input);
        validateRate(rate);
        return movieRateGateway.rateMovie(rate);
    }

    public MovieRate updateRate(MovieRateInput rateUpdated) {
        Optional<MovieRate> oldMovieOpt = movieRateGateway.findById(rateUpdated.id());
        if(oldMovieOpt.isEmpty()){
            throw new ElementNotFoundException("Movie not found");
        }
        MovieRate rate = oldMovieOpt.get();
        rate.update(toModel(rateUpdated));
        return movieRateGateway.updateRate(rate);
    }

    private void validateRate(MovieRate rate){
        if(rate.getRate()== null){
            throw new ApiException("Rate cannot be null");
        }
        if(rate.getRate()<=0){
            throw new ApiException("Rate must be greater or equal than 0");
        }
        if(rate.getRate()>10){
                throw new ApiException("Rate must be less or equal than 10");
        }
        if(rate.getMovie()==null){
            throw new ApiException("Movie cannot be null");
        }
        if(rate.getUser()==null){
            throw new ApiException("User cannot be null");
        }
        if(movieRateGateway.findByMovieAndUser(rate.getMovie().getId(), rate.getUser().getId()).isPresent()){
            throw new ApiException("User already rated this movie");
        }
    }
    public List<MovieRate> getRates(UUID movie, UUID user) {
        return movieRateGateway.getRates( movie, user);
    }





}
