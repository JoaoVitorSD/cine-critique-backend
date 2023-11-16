package softeng.cinecritique.infraestructure.controllers.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UserRequest(UUID id,
                          @NotEmpty(message = "Name cannot be empty") String name,
                          @NotNull(message = "Username cannot be null")
                          String userName,
                          @NotNull(message = "Age cannot be null")
                          @Min(value = 5, message = "Age must be greater than 5")
                          Integer age,
                          @NotNull(message = "Email cannot be null")
                          @Email(message = "Email should be valid")
                          String email) {
}
