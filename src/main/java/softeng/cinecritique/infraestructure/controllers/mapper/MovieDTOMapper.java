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
        return new MovieResponse(movie.getId(), movie.getName(), movie.getDescription(), movie.getCreatedAt(), movie.getGenres().stream().map(Genre::getName).toList());
    }
}
