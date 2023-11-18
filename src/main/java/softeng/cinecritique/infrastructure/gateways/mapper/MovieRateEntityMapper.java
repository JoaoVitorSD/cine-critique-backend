package softeng.cinecritique.infrastructure.gateways.mapper;

import softeng.cinecritique.app.domain.MovieRate;
import softeng.cinecritique.infrastructure.entity.MovieRateEntity;

public class MovieRateEntityMapper {

    public static MovieRate toModel(MovieRateEntity movieRate){
        return  new MovieRate(movieRate.getId(), MovieEntityMapper.toModelWithoutRates(movieRate.getMovie()),movieRate.getRate(), UserEntityMapper.toModel(movieRate.getUser()));
    }

    public static MovieRate toModelWithoutMovie(MovieRateEntity movieRate){
        return  new MovieRate(movieRate.getId(), null,movieRate.getRate(), UserEntityMapper.toModel(movieRate.getUser()));
    }

    public static MovieRateEntity toEntity(MovieRate movieRate){
        return  new MovieRateEntity(movieRate.getId(), MovieEntityMapper.toEntityWithoutRates(movieRate.getMovie()),movieRate.getRate(), UserEntityMapper.toEntity(movieRate.getUser()));
    }
}
