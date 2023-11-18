package softeng.cinecritique.infrastructure.controllers.mapper;

import softeng.cinecritique.app.domain.MovieRate;
import softeng.cinecritique.app.domain.input.MovieRateInput;
import softeng.cinecritique.infrastructure.controllers.request.MovieRateRequest;
import softeng.cinecritique.infrastructure.controllers.response.MovieRateResponse;

public class MovieRateDTOMapper {

    public MovieRateResponse toResponse(MovieRate movieRate){
        return new MovieRateResponse(movieRate.getId(), movieRate.getMovie().getName(), movieRate.getRate(), movieRate.getUser().getUsername());
    }

    public MovieRateInput toMovieRateInput(MovieRateRequest request){

        return new MovieRateInput(request.id(),request.movie(), request.username(),  request.rate());
    }
}
