package softeng.cinecritique.infraestructure.controllers.mapper;

import softeng.cinecritique.app.domain.User;
import softeng.cinecritique.infraestructure.controllers.request.UserRequest;
import softeng.cinecritique.infraestructure.controllers.response.UserResponse;

public class UserDTOMapper {

    public UserResponse toResponse(User user){
        return new UserResponse(user.getId(), user.getName(), user.getUsername(), user.getAge(), user.getEmail());
    }

    public User toUser(UserRequest request){
        return new User(request.id(), request.name(), request.username(), request.age(), request.email());
    }
}
