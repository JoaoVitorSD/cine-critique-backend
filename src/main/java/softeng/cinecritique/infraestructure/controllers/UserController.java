package softeng.cinecritique.infraestructure.controllers;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.app.domain.User;
import softeng.cinecritique.app.usecases.UserInteractor;
import softeng.cinecritique.infraestructure.controllers.mapper.UserDTOMapper;
import softeng.cinecritique.infraestructure.controllers.request.UserRequest;
import softeng.cinecritique.infraestructure.controllers.response.UserResponse;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private final UserInteractor userInteractor;
    private final UserDTOMapper userDTOMapper;

    public UserController(UserInteractor userInteractor, UserDTOMapper userDTOMapper) {
        this.userInteractor = userInteractor;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "User - Register")
    public UserResponse createUser(@RequestBody @Valid UserRequest request){
        User user = userDTOMapper.toUser(request);
        return userDTOMapper.toResponse(userInteractor.createUser(user));
    }

    @PutMapping("/register")
    @Operation(summary = "User - Register")
    public UserResponse updateUser(@RequestBody @Valid UserRequest request){
        User user = userDTOMapper.toUser(request);
        return userDTOMapper.toResponse(userInteractor.updateUser(user));
    }

    @GetMapping("/user")
    @Operation(summary = "List Users")
    public PageModel<UserResponse> listUsers(@RequestParam(defaultValue = "0") Integer page,
                                             @RequestParam(defaultValue = "10") Integer size, @RequestParam(defaultValue = "") String userName){
        return userInteractor.listUsers(page, size, userName).map(userDTOMapper::toResponse);
    }
}
