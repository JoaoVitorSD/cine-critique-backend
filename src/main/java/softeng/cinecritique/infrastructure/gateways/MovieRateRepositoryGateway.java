package softeng.cinecritique.infrastructure.gateways;

import softeng.cinecritique.app.domain.MovieRate;
import softeng.cinecritique.app.gateway.MovieRateGateway;
import softeng.cinecritique.infrastructure.entity.MovieRateEntity;
import softeng.cinecritique.infrastructure.gateways.mapper.MovieRateEntityMapper;
import softeng.cinecritique.infrastructure.persistence.MovieRateRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MovieRateRepositoryGateway implements MovieRateGateway {
    private final MovieRateRepository movieRateRepository;


    public MovieRateRepositoryGateway(MovieRateRepository movieRateRepository) {
        this.movieRateRepository = movieRateRepository;
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
    public List<MovieRate> getRates(UUID movieId, UUID user) {
        return movieRateRepository.findByMovieAndUserNulls(movieId, user).stream().map(MovieRateEntityMapper::toModel).toList();
    }


    @Override
    public Optional<MovieRate> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<MovieRate> findByMovieAndUser(UUID movie, UUID user) {
        return movieRateRepository.findByMovieAndUser(movie, user).map(MovieRateEntityMapper::toModel);
    }
}
