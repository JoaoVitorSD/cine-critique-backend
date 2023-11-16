package softeng.cinecritique.infraestructure.controllers.mapper;

import softeng.cinecritique.app.domain.Genre;
import softeng.cinecritique.infraestructure.controllers.request.GenreRequest;
import softeng.cinecritique.infraestructure.controllers.response.GenreResponse;

public class GenreDTOMapper {
    public Genre toModel(GenreRequest request){
        return new Genre(request.id(), request.name(), null, null);
    }

    public GenreResponse toResponse(Genre genre){
        return new GenreResponse(genre.getId(), genre.getName(), genre.getCreatedAt(), genre.getMovies());
    }
}
