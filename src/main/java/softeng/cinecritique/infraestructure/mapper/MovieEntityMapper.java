package softeng.cinecritique.infraestructure.mapper;

import softeng.cinecritique.app.domain.Movie;
import softeng.cinecritique.infraestructure.entity.MovieEntity;

import java.util.stream.Collectors;

public class MovieEntityMapper {

    public static MovieEntity toEntity(Movie movieModel){
        return new MovieEntity(movieModel.getId(), movieModel.getName(), movieModel.getDescription(),movieModel.getFilmedAt(),movieModel.getCreatedAt(),
                movieModel.getGenres().stream().map(GenreEntityMapper::toEntity).collect(Collectors.toList()));
    }


    public static MovieEntity toEntityWithoutGenre(Movie movieModel){
        return new MovieEntity(movieModel.getId(), movieModel.getName(),movieModel.getDescription(),movieModel.getFilmedAt(),movieModel.getCreatedAt(), null);
    }
    public static Movie toModel(MovieEntity entity){
        return new Movie(entity.getId(), entity.getName(),entity.getDescription(), entity.getCreatedAt(),entity.getFilmedAt(),
                entity.getGenres().stream().map(GenreEntityMapper::toModel).collect(Collectors.toList()));
    }
    public static  Movie toModelWithoutGenre(MovieEntity entity){
        return new Movie(entity.getId(), entity.getName(),entity.getDescription(), entity.getCreatedAt(),entity.getFilmedAt(), null);
    }
}
