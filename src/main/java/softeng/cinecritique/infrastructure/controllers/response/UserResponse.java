package softeng.cinecritique.infrastructure.controllers.response;

import java.util.UUID;

public record UserResponse(UUID id, String name, String userName, Integer age, String email) {
}
