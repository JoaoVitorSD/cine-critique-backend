package softeng.cinecritique.app.service;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import softeng.cinecritique.app.dto.request.UserDTORequest;
import softeng.cinecritique.app.dto.response.UserDTOResponse;
import softeng.cinecritique.app.entity.UserEntity;
import softeng.cinecritique.app.ports.output.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTOResponse> findAll() {
        return userRepository.findAll()
                .stream().map(UserDTOResponse::new)
                .collect(Collectors.toList());
    }

    public UserDTOResponse insert(UserDTORequest request) {
        if(userRepository.existsByEmail(request.getEmail())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Email already exists");
        }
        return new UserDTOResponse(userRepository.save(requetToEntity(request)));
    }

    public UserEntity requetToEntity(UserDTORequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(request.getAge());
        userEntity.setEmail(request.getEmail());
        userEntity.setName(request.getName());
        userEntity.setUserName(request.getUserName());
        return userEntity;
    }

}
