package softeng.cinecritique.infrastructure.gateways.mapper;

import org.springframework.data.domain.Page;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.app.domain.User;
import softeng.cinecritique.infrastructure.entity.UserEntity;

import java.util.List;

public class UserEntityMapper {

    public static PageModel<User> toPageModel(Page<UserEntity> page){
        List<User> users = page.getContent().stream().map(UserEntityMapper::toModel).toList();
        return new PageModel<>(users, page.getTotalPages(), page.getTotalElements(), page.getPageable().getPageSize(), page.getPageable().getPageNumber());
    }
    public static UserEntity toEntity(User userModel){
        return new UserEntity(userModel.getId(), userModel.getName(), userModel.getPassword(), userModel.getUsername(), userModel.getAge(), userModel.getEmail());
    }

    public static User toModel(UserEntity entity){
        return new User(entity.getId(), entity.getName(), entity.getUsername(), entity.getAge(), entity.getEmail());
    }
}
