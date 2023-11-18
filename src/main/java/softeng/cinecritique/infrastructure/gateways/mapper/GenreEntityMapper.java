package softeng.cinecritique.infrastructure.gateways.mapper;

import org.springframework.data.domain.Page;
import softeng.cinecritique.app.domain.Genre;
import softeng.cinecritique.app.domain.Movie;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.infrastructure.entity.GenreEntity;

import java.util.List;
import java.util.stream.Collectors;

public class GenreEntityMapper {


    public static PageModel<Genre> toPageModel(Page<GenreEntity> entityPage){
        List<Genre> genres = entityPage.getContent().stream().map(GenreEntityMapper::toModel).collect(Collectors.toList());

        return new PageModel<>(genres, entityPage.getTotalPages(), entityPage.getTotalElements(), entityPage.getPageable().getPageSize(), entityPage.getPageable().getPageNumber());
    }
    public static  GenreEntity toEntity(Genre genreModel){
        return new GenreEntity(genreModel.getId(), genreModel.getName(), genreModel.getCreatedAt(),null);
    }

    public static Genre toModel(GenreEntity entity){
        if(entity.getMovies() == null)
            return new Genre(entity.getId(), entity.getName(), entity.getCreation_date(), null);

        List<Movie> movies = entity.getMovies().stream().map(MovieEntityMapper::toModelWithoutGenreAndRate).collect(Collectors.toList());
        return new Genre(entity.getId(), entity.getName(), entity.getCreation_date(), movies);
    }
}
