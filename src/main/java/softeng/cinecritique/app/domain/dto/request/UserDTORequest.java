package softeng.cinecritique.app.domain.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTORequest {
    private UUID id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotEmpty(message = "Username cannot be empty")
    private String userName;

    @Min(value = 13, message = "Age must be greater than 18")
    @Max(value = 120, message = "Age must be less than 120, you much older")
    private Integer age;
    @NotNull(message = "Email cannot be empty")
    private String email;



}
