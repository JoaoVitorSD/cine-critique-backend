package softeng.cinecritique.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softeng.cinecritique.app.gateway.UserGateway;
import softeng.cinecritique.app.usecases.UserInteractor;
import softeng.cinecritique.infrastructure.controllers.mapper.UserDTOMapper;
import softeng.cinecritique.infrastructure.gateways.UserRepositoryGateway;
import softeng.cinecritique.infrastructure.persistence.UserRepository;

@Configuration
public class UserConfig {
    @Bean
    UserInteractor userInteractor(UserGateway userGateway){
        return new UserInteractor(userGateway);
    }

    @Bean
    UserGateway userGateway(UserRepository userRepository){
        return new UserRepositoryGateway(userRepository);
    }

    @Bean
    UserDTOMapper userDTOMapper(){
        return new UserDTOMapper();
    }
}
