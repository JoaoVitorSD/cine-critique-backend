package softeng.cinecritique.infrastructure.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import softeng.cinecritique.app.domain.PageModel;
import softeng.cinecritique.app.domain.User;
import softeng.cinecritique.app.usecases.UserInteractor;
import softeng.cinecritique.infrastructure.controllers.mapper.UserDTOMapper;
import softeng.cinecritique.infrastructure.controllers.request.UserRequest;
import softeng.cinecritique.infrastructure.controllers.response.UserResponse;

@RestController
@RequestMapping("api/v1")
@Tag(name = "User", description = " Account managing and listing")
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
    @Operation(summary = "List Users by username")
    public PageModel<UserResponse> listUsers(@RequestParam(defaultValue = "0") Integer page,
                                             @RequestParam(defaultValue = "10") Integer size, @RequestParam(defaultValue = "") String username){
        return userInteractor.listUsers(page, size, username).map(userDTOMapper::toResponse);
    }
}
