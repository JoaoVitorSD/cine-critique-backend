package softeng.cinecritique.app.ports.input;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import softeng.cinecritique.app.domain.User;
import softeng.cinecritique.app.dto.request.UserDTORequest;
import softeng.cinecritique.app.dto.response.UserDTOResponse;
import softeng.cinecritique.app.entity.UserEntity;

import java.util.List;
import java.util.UUID;
public interface UserAPIPort {

    @PostMapping
    UserDTOResponse insert(@Valid UserDTORequest user);

    @GetMapping
    List<UserDTOResponse> find();

    @GetMapping("{id}")
    User findById(@PathVariable(required = true) String id);

    @DeleteMapping
    void delete( UUID id);


    @PutMapping
    User update(@PathVariable UUID id);
}
