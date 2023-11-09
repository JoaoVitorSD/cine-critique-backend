package softeng.cinecritique.adapters.input;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import softeng.cinecritique.app.domain.User;
import softeng.cinecritique.app.domain.dto.request.UserDTORequest;
import softeng.cinecritique.app.domain.dto.response.UserDTOResponse;
import softeng.cinecritique.app.ports.input.UserAPIPort;
import softeng.cinecritique.app.service.UserService;

import java.util.List;
import java.util.UUID;
@RequestMapping("user/")
@RestController
public class UserAPIController  implements UserAPIPort {

    private UserService userService;

    public UserAPIController(UserService userService) {
        this.userService = userService;
    }
    @Override
    @PostMapping
    public UserDTOResponse insert(@RequestBody @Valid UserDTORequest user) {
       return userService.insert(user);
    }

    @GetMapping("")
    public List<UserDTOResponse> find() {
        return userService.findAll();
    }
    @Override
    @GetMapping("id/{id}")
    public User findById(@PathVariable String id) {
        return new User(UUID.randomUUID(),"Nome", 10, "1111111","bife@gmail.com", true);
    }
    @Override
    public void delete( UUID id) {

    }
    @Override
    public User update( UUID id) {
        return null;
    }



}
