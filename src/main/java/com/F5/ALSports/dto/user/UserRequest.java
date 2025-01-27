package com.F5.ALSports.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;

public record UserRequest(

        @NotBlank(message = "Name is required")
        String name,
        @Pattern(regexp = "Is not a email format")
        String email,
        String password

) {

}
