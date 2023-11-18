package softeng.cinecritique.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softeng.cinecritique.app.usecases.MovieInteractor;
import softeng.cinecritique.infrastructure.controllers.mapper.MovieDTOMapper;
import softeng.cinecritique.infrastructure.gateways.GenreRepositoryGateway;
import softeng.cinecritique.infrastructure.gateways.MovieRepositoryGateway;
import softeng.cinecritique.infrastructure.persistence.MovieRepository;

@Configuration
public class MovieConfig {

    @Bean
    MovieInteractor movieInteractor(MovieRepositoryGateway movieRepositoryGateway, GenreRepositoryGateway genreRepositoryGateway){
        return new MovieInteractor(movieRepositoryGateway,genreRepositoryGateway);
    }

    @Bean
    MovieRepositoryGateway movieRepositoryGateway(MovieRepository repository){
        return new MovieRepositoryGateway(repository);
    }

    @Bean
    MovieDTOMapper movieDTOMapper(){
        return new MovieDTOMapper();
    }
}
