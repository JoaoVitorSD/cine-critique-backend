package softeng.cinecritique.infraestructure.gateways.mapper;

import softeng.cinecritique.app.domain.MovieRate;
import softeng.cinecritique.infraestructure.entity.MovieRateEntity;

public class MovieRateEntityMapper {

    public static MovieRate toModel(MovieRateEntity movieRate){
        return  new MovieRate(movieRate.getId(), MovieEntityMapper.toModel(movieRate.getMovie()),movieRate.getRate(), UserEntityMapper.toModel(movieRate.getUser()));
    }

    public static MovieRate toModelWithoutMovie(MovieRateEntity movieRate){
        return  new MovieRate(movieRate.getId(), null,movieRate.getRate(), UserEntityMapper.toModel(movieRate.getUser()));
    }

    public static MovieRateEntity toEntity(MovieRate movieRate){
        return  new MovieRateEntity(movieRate.getId(), MovieEntityMapper.toEntity(movieRate.getMovie()),movieRate.getRate(), UserEntityMapper.toEntity(movieRate.getUser()));
    }
}
