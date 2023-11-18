package softeng.cinecritique.app.usecases;

import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.app.gateway.UserGateway;
import softeng.cinecritique.app.domain.User;
import softeng.cinecritique.app.domain.exception.ApiException;

public class UserInteractor {
    private UserGateway userGateway;

    public UserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User createUser(User user){
        if(userGateway.existsByEmail(user.getEmail(), user.getId()))
            throw new ApiException("Email in use");

        user.setPassword(userGateway.encodePassword(user.getPassword()));
        return userGateway.createUser(user);
    }
    public User updateUser(User user){
        if(user.getId() == null)
            throw new ApiException("User id is required for update");
        if(userGateway.existsByEmail(user.getEmail(), user.getId()))
            throw new ApiException("Email in use");

        return userGateway.updateUser(user);
    }


    public PageModel<User> listUsers(Integer page, Integer size, String name){
        return userGateway.listUsers(page, size, name);
    }

}
