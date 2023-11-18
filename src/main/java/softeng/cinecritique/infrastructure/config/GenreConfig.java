package softeng.cinecritique.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softeng.cinecritique.app.usecases.GenreInteractor;
import softeng.cinecritique.infrastructure.controllers.mapper.GenreDTOMapper;
import softeng.cinecritique.infrastructure.gateways.GenreRepositoryGateway;
import softeng.cinecritique.infrastructure.persistence.GenreRepository;

@Configuration
public class GenreConfig {

    @Bean
    GenreInteractor genreInteractor(GenreRepositoryGateway genreRepositoryGateway){
        return new GenreInteractor(genreRepositoryGateway);
    }

    @Bean
    GenreRepositoryGateway genreRepositoryGateway(GenreRepository repository){
        return new GenreRepositoryGateway(repository);
    }

    @Bean
    GenreDTOMapper genreDTOMapper(){
        return new GenreDTOMapper();
    }
}
