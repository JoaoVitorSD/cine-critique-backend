package softeng.cinecritique.infraestructure.controllers.mapper;

import softeng.cinecritique.app.domain.Movie;
import softeng.cinecritique.app.domain.MovieRate;
import softeng.cinecritique.app.domain.input.MovieRateInput;
import softeng.cinecritique.infraestructure.controllers.request.MovieRateRequest;
import softeng.cinecritique.infraestructure.controllers.response.MovieRateResponse;
import softeng.cinecritique.infraestructure.controllers.response.MovieRateResponse;

public class MovieRateDTOMapper {

    public MovieRateResponse toResponse(MovieRate movieRate){
        return new MovieRateResponse(movieRate.getId(), movieRate.getMovie().getName(), movieRate.getRate(), movieRate.getUser().getUsername());
    }

    public MovieRateInput toMovieRateInput(MovieRateRequest request){

        return new MovieRateInput(request.id(),request.movie(), request.username(),  request.rate());
    }
}
