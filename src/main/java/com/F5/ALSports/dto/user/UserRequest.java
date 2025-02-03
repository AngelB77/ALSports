package com.F5.ALSports.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public record UserRequest(

        @NotBlank(message = "Name can't be empty ")
        @Size(min = 1, max = 50, message = "Name must contain min 1 and max 50 characters")
        String name,
        @Pattern(regexp = "Is not a email format")
        @Email(message = "Email must be in the correct format")
        String email,
        @NotBlank(message = "Password is required")
        String password

) {

}
