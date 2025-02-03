package com.F5.ALSports.dto.products;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public record ProductRequest(
        @NotBlank(message = "Name is required")
        String name,

        int price,
        @URL(
                protocol = "https",
                host = "example.com",
                message = "The image URL is not correct"
        )
        String ImageUrl

) {
}
