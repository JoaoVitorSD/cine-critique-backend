package softeng.cinecritique.infraestructure.gateways;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.infraestructure.entity.UserEntity;
import softeng.cinecritique.app.gateway.UserGateway;
import softeng.cinecritique.app.domain.User;
import softeng.cinecritique.infraestructure.mapper.UserEntityMapper;
import softeng.cinecritique.infraestructure.persistence.UserRepository;

import java.util.UUID;

public class UserRepositoryGateway implements UserGateway {
    private final UserRepository userRepository;

    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        return userEntityMapper.toModel(userRepository.save(userEntity));
    }

    @Override
    public User updateUser(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        return userEntityMapper.toModel(userRepository.save(userEntity));
    }

    @Override
    public PageModel<User> listUsers(Integer page, Integer size, String name) {
        return userEntityMapper.toPageModel(userRepository.findAllByUserNameContainingIgnoreCase(name, PageRequest.of(page, size)));
    }

    @Override
    public boolean existsByIgnoreCaseUserNameAndIdNot(String userName, UUID id) {
        return userRepository.existsByIgnoreCaseUserNameAndIdNot(userName, id);
    }


}
