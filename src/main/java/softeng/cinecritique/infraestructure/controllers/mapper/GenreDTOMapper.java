package softeng.cinecritique.infraestructure.controllers.mapper;

import softeng.cinecritique.app.domain.Genre;
import softeng.cinecritique.app.domain.Movie;
import softeng.cinecritique.infraestructure.controllers.request.GenreRequest;
import softeng.cinecritique.infraestructure.controllers.response.GenreMovieResponse;
import softeng.cinecritique.infraestructure.controllers.response.GenreResponse;

public class GenreDTOMapper {
    public Genre toModel(GenreRequest request){
        return new Genre(request.id(), request.name(), null, null);
    }

    public GenreMovieResponse toGenreMovieResponse(Movie genre){
        return new GenreMovieResponse(genre.getId(), genre.getName(), genre.getDescription(), genre.getCreatedAt());
    }

    public GenreResponse toResponse(Genre genre){
        return new GenreResponse(genre.getId(), genre.getName(), genre.getCreatedAt(), genre.getMovies().stream().map(this::toGenreMovieResponse).toList());
    }
}
