package softeng.cinecritique.infrastructure.controllers.request;

import jakarta.validation.constraints.*;

import java.util.UUID;

public record UserRequest(UUID id,
                          @NotEmpty(message = "Name cannot be empty") String name,
                          @NotNull(message = "Username cannot be null")
                          String username,
                          @NotEmpty(message = "Password cannot be empty")
                          @Size(min = 8, message = "Password must be at least 8 characters long")
                          String password,
                          @NotNull(message = "Age cannot be null")
                          @Min(value = 5, message = "Age must be greater than 5")
                          Integer age,
                          @NotNull(message = "Email cannot be null")
                          @Email(message = "Email should be valid")
                          String email) {
}
