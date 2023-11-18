package softeng.cinecritique.infrastructure.gateways;

import org.springframework.data.domain.PageRequest;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.infrastructure.entity.UserEntity;
import softeng.cinecritique.app.gateway.UserGateway;
import softeng.cinecritique.app.domain.User;
import softeng.cinecritique.infrastructure.gateways.mapper.UserEntityMapper;
import softeng.cinecritique.infrastructure.persistence.UserRepository;

import java.util.Optional;
import java.util.UUID;

public class UserRepositoryGateway implements UserGateway {
    private final UserRepository userRepository;


    public UserRepositoryGateway(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = UserEntityMapper.toEntity(user);
        return UserEntityMapper.toModel(userRepository.save(userEntity));
    }

    @Override
    public User updateUser(User user) {
        UserEntity userEntity = UserEntityMapper.toEntity(user);
        return UserEntityMapper.toModel(userRepository.save(userEntity));
    }

    @Override
    public PageModel<User> listUsers(Integer page, Integer size, String name) {
        return UserEntityMapper.toPageModel(userRepository.findAllByUsernameContainingIgnoreCase(name, PageRequest.of(page, size)));
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id).map(UserEntityMapper::toModel);
    }

    @Override
    public boolean existsByEmail(String email, UUID id) {
        return userRepository.existsByEmailAndIdNot(email, id);
    }

    @Override
    public String encodePassword(String password) {
        return password;
    }


}
