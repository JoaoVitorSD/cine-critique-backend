package softeng.cinecritique.infraestructure.gateways;

import softeng.cinecritique.app.domain.MovieRate;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.app.gateway.MovieRateGateway;
import softeng.cinecritique.infraestructure.entity.MovieRateEntity;
import softeng.cinecritique.infraestructure.gateways.mapper.MovieRateEntityMapper;
import softeng.cinecritique.infraestructure.persistence.MovieRateRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MovieRateRepositoryGateway implements MovieRateGateway {
    private final MovieRateRepository movieRateRepository;

    private final MovieRateEntityMapper movieRateEntityMapper;

    public MovieRateRepositoryGateway(MovieRateRepository movieRateRepository, MovieRateEntityMapper movieRateEntityMapper) {
        this.movieRateRepository = movieRateRepository;
        this.movieRateEntityMapper = movieRateEntityMapper;
    }


    @Override
    public MovieRate rateMovie(MovieRate rate) {
        MovieRateEntity entity = MovieRateEntityMapper.toEntity(rate);
        return MovieRateEntityMapper.toModel(movieRateRepository.save(entity));
    }

    @Override
    public MovieRate updateRate(MovieRate rate) {
        MovieRateEntity entity = MovieRateEntityMapper.toEntity(rate);
        return MovieRateEntityMapper.toModel(movieRateRepository.save(entity));
    }

    @Override
    public List<MovieRate> getRates(UUID movieId, String username) {
        return movieRateRepository.findByMovieAndUserName(movieId, username).stream().map(MovieRateEntityMapper::toModel).toList();
    }


    @Override
    public Optional<MovieRate> findById(UUID id) {
        return Optional.empty();
    }
}