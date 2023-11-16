package softeng.cinecritique.infraestructure.gateways;

import org.springframework.data.domain.PageRequest;
import softeng.cinecritique.app.domain.Genre;
import softeng.cinecritique.app.domain.Movie;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.app.gateway.MovieGateway;
import softeng.cinecritique.infraestructure.entity.GenreEntity;
import softeng.cinecritique.infraestructure.entity.MovieEntity;
import softeng.cinecritique.infraestructure.mapper.MovieEntityMapper;
import softeng.cinecritique.infraestructure.persistence.GenreRepository;
import softeng.cinecritique.infraestructure.persistence.MovieRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MovieRepositoryGateway implements MovieGateway {
    private final MovieRepository movieRepository;


    public MovieRepositoryGateway(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie createMovie(Movie movie){
        MovieEntity entity = MovieEntityMapper.toEntity(movie);
        return MovieEntityMapper.toModel(movieRepository.save(entity));

    }

    @Override
    public Movie updateMovie(Movie movie) {
        MovieEntity entity = MovieEntityMapper.toEntity(movie);
        return MovieEntityMapper.toModel(movieRepository.save(entity));
    }

    @Override
    public PageModel<Movie> getMovies(Integer page, Integer size, String name, String genre) {
        return MovieEntityMapper.toPageModel(movieRepository.findByNameAndGenre(name, genre,PageRequest.of(page, size)));
    }

    @Override
    public void rateMovie(Movie movie, Integer rating) {

    }


    @Override
    public Optional<Movie> findById(UUID id) {
        return movieRepository.findById(id).map(MovieEntityMapper::toModel);
    }
}
