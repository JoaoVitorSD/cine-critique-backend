package softeng.cinecritique.infraestructure.controllers;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.app.usecases.UserInteractor;
import softeng.cinecritique.app.domain.User;
import softeng.cinecritique.infraestructure.controllers.mapper.UserDTOMapper;
import softeng.cinecritique.infraestructure.controllers.request.UserRequest;
import softeng.cinecritique.infraestructure.controllers.response.UserResponse;

@RestController
@RequestMapping("v1/user")
public class UserController {
    private final UserInteractor userInteractor;
    private final UserDTOMapper userDTOMapper;

    public UserController(UserInteractor userInteractor, UserDTOMapper userDTOMapper) {
        this.userInteractor = userInteractor;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody @Valid UserRequest request){
        User user = userDTOMapper.toUser(request);
        return userDTOMapper.toResponse(userInteractor.createUser(user));
    }

    @PutMapping
    public UserResponse updateUser(@RequestBody @Valid UserRequest request){
        User user = userDTOMapper.toUser(request);
        return userDTOMapper.toResponse(userInteractor.updateUser(user));
    }

    @GetMapping
    public PageModel<UserResponse> listUsers(@RequestParam(defaultValue = "0") Integer page,
                                             @RequestParam(defaultValue = "10") Integer size, @RequestParam(defaultValue = "") String userName){
        return userInteractor.listUsers(page, size, userName).map(userDTOMapper::toResponse);
    }
}
