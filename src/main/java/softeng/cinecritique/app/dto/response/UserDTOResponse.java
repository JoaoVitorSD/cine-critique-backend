package softeng.cinecritique.app.dto.response;

import lombok.Getter;
import lombok.Setter;
import softeng.cinecritique.app.entity.UserEntity;

import java.util.UUID;

@Getter
@Setter
public class UserDTOResponse {

    private UUID id;
    private String name;
    private String userName;
    private Integer age;
    private String email;

    public UserDTOResponse(UserEntity entity){
        this.name = entity.getName();
        this.userName = entity.getUserName();
        this.id = entity.getId();
        this.age = entity.getAge();
        this.email = entity.getEmail();
    }

}
