package softeng.cinecritique.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softeng.cinecritique.app.usecases.MovieRateInteractor;
import softeng.cinecritique.infraestructure.controllers.mapper.MovieRateDTOMapper;
import softeng.cinecritique.infraestructure.gateways.GenreRepositoryGateway;
import softeng.cinecritique.infraestructure.gateways.MovieRateRepositoryGateway;
import softeng.cinecritique.infraestructure.gateways.MovieRepositoryGateway;
import softeng.cinecritique.infraestructure.gateways.UserRepositoryGateway;
import softeng.cinecritique.infraestructure.persistence.MovieRateRepository;
import softeng.cinecritique.infraestructure.persistence.UserRepository;

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
