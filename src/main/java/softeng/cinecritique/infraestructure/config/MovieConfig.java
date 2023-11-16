package softeng.cinecritique.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softeng.cinecritique.app.usecases.MovieInteractor;
import softeng.cinecritique.infraestructure.controllers.mapper.MovieDTOMapper;
import softeng.cinecritique.infraestructure.gateways.GenreRepositoryGateway;
import softeng.cinecritique.infraestructure.gateways.MovieRepositoryGateway;
import softeng.cinecritique.infraestructure.persistence.MovieRepository;

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
