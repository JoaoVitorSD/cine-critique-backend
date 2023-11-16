package softeng.cinecritique.infraestructure.mapper;

import org.springframework.data.domain.Page;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.app.domain.User;
import softeng.cinecritique.infraestructure.entity.UserEntity;

import java.util.List;

public class UserEntityMapper {

    public PageModel<User> toPageModel(Page<UserEntity> page){
        List<User> users = page.getContent().stream().map(this::toModel).toList();
        return new PageModel<>(users, page.getTotalPages(), page.getTotalElements(), page.getPageable().getPageSize(), page.getPageable().getPageNumber());
    }
    public UserEntity toEntity(User userModel){
        return new UserEntity(userModel.getId(), userModel.getName(), userModel.getUserName(), userModel.getAge(), userModel.getEmail());
    }

    public User toModel(UserEntity entity){
        return new User(entity.getId(), entity.getName(), entity.getUserName(), entity.getAge(), entity.getEmail());
    }
}
