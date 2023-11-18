package softeng.cinecritique.infrastructure.gateways;

import org.springframework.data.domain.PageRequest;
import softeng.cinecritique.app.domain.Movie;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.app.gateway.MovieGateway;
import softeng.cinecritique.infrastructure.entity.MovieEntity;
import softeng.cinecritique.infrastructure.gateways.mapper.MovieEntityMapper;
import softeng.cinecritique.infrastructure.persistence.MovieRepository;

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
    public Optional<Movie> findById(UUID id) {
        return movieRepository.findById(id).map(MovieEntityMapper::toModel);
    }
}
