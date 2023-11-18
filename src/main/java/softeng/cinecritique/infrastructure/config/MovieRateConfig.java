package softeng.cinecritique.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softeng.cinecritique.app.usecases.MovieRateInteractor;
import softeng.cinecritique.infrastructure.controllers.mapper.MovieRateDTOMapper;
import softeng.cinecritique.infrastructure.gateways.MovieRateRepositoryGateway;
import softeng.cinecritique.infrastructure.gateways.MovieRepositoryGateway;
import softeng.cinecritique.infrastructure.gateways.UserRepositoryGateway;
import softeng.cinecritique.infrastructure.persistence.MovieRateRepository;
import softeng.cinecritique.infrastructure.persistence.UserRepository;

@Configuration
public class MovieRateConfig {

    @Bean
    MovieRateInteractor movieRateInteractor(MovieRepositoryGateway movieRepositoryGateway,MovieRateRepositoryGateway movieRateRepositoryGateway,UserRepositoryGateway userRepositoryGateway){
        return new MovieRateInteractor(  movieRepositoryGateway,userRepositoryGateway,movieRateRepositoryGateway);
    }

    @Bean
    MovieRateRepositoryGateway movieRateRepositoryGateway(MovieRateRepository repository){
        return new MovieRateRepositoryGateway(repository);
    }
    @Bean
    UserRepositoryGateway userRepositoryGateway(UserRepository repository){
        return new UserRepositoryGateway(repository);
    }


    @Bean
    MovieRateDTOMapper movieRateDTOMapper(){
        return new MovieRateDTOMapper();
    }
}
