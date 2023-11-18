package softeng.cinecritique.infrastructure.controllers.mapper;

import softeng.cinecritique.app.domain.Genre;
import softeng.cinecritique.app.domain.Movie;
import softeng.cinecritique.infrastructure.controllers.request.GenreRequest;
import softeng.cinecritique.infrastructure.controllers.response.GenreMovieResponse;
import softeng.cinecritique.infrastructure.controllers.response.GenreResponse;

public class GenreDTOMapper {
    public Genre toModel(GenreRequest request) {
        return new Genre(request.id(), request.name(), null, null);
    }

    public GenreMovieResponse toGenreMovieResponse(Movie movie) {
        if(movie.getRates() == null){
            return new GenreMovieResponse(movie.getId(), movie.getName(), movie.getDescription(), movie.getCreatedAt(), 0f);
        }
        int size = !movie.getRates().isEmpty() ? movie.getRates().size() : 1;
        Float rateAvg = movie.getRates().stream().reduce(0f, (acc, rate) -> acc + rate.getRate(), Float::sum) / size;

        return new GenreMovieResponse(movie.getId(), movie.getName(), movie.getDescription(), movie.getCreatedAt(), rateAvg);
    }

    public GenreResponse toResponse(Genre genre) {
        if (genre.getMovies() != null) {
            return new GenreResponse(genre.getId(), genre.getName(), genre.getCreatedAt(), genre.getMovies().stream().map(this::toGenreMovieResponse).toList());
        }
        
        return new GenreResponse(genre.getId(), genre.getName(), genre.getCreatedAt(), null);
    }
}
