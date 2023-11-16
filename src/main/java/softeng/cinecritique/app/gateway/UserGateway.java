package softeng.cinecritique.app.gateway;

import org.springframework.data.domain.Page;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.app.domain.User;

import java.util.UUID;

public interface UserGateway {
    User createUser(User user);


    User updateUser(User user);


    PageModel<User> listUsers(Integer page, Integer size, String name);



    boolean existsByIgnoreCaseUserNameAndIdNot(String userName, UUID id);
}
