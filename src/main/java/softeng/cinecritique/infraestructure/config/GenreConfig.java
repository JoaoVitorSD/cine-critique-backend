package softeng.cinecritique.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softeng.cinecritique.app.gateway.GenreGateway;
import softeng.cinecritique.app.usecases.GenreInteractor;
import softeng.cinecritique.infraestructure.controllers.mapper.GenreDTOMapper;
import softeng.cinecritique.infraestructure.gateways.GenreRepositoryGateway;
import softeng.cinecritique.infraestructure.persistence.GenreRepository;

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
