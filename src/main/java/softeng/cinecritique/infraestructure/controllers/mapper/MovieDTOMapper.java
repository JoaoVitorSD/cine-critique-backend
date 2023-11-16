package softeng.cinecritique.infraestructure.controllers.mapper;

import softeng.cinecritique.app.domain.Genre;
import softeng.cinecritique.app.domain.Movie;
import softeng.cinecritique.infraestructure.controllers.request.MovieRequest;
import softeng.cinecritique.infraestructure.controllers.response.MovieResponse;

public class MovieDTOMapper {
    public Movie toModel(MovieRequest request){
        return new Movie(request.id(), request.name(), request.description(), request.filmedAt(), null, request.genres().stream().map(Genre::new).toList(), null);
    }


    public MovieResponse toResponse(Movie movie){

        int size = !movie.getRates().isEmpty() ? movie.getRates().size():1;
        Float rateAvg = movie.getRates().stream().reduce(0f, (acc, rate) -> acc + rate.getRate(), Float::sum) / size ;
        return new MovieResponse(movie.getId(), movie.getName(), movie.getDescription(), movie.getCreatedAt(), movie.getGenres().stream().map(Genre::getName).toList(), rateAvg);
    }
}
