package bg.martin_aleksandrov.themoneylfow.domain.dtos.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterFormDto {
    @NotBlank
    @Size(min = 2, max = 20)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 20)
    private String lastName;

    @NotBlank
    private String gender;

    @NotBlank
    @Email
    private String email;

    @Size(min = 5, max = 20)
    @NotNull
    private String password;

    @NotBlank
    private String confirmPassword;

}
