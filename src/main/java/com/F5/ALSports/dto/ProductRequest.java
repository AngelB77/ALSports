package com.F5.ALSports.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public record ProductRequest(
        @NotBlank(message = "Name is required")
        String name,

        int price,

        @NotBlank(message = "Url is required")
        String ImageUrl

) {
}
