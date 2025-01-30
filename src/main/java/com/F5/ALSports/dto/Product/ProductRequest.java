package com.F5.ALSports.dto.Product;

import jakarta.validation.constraints.NotBlank;

public record ProductRequest(
        @NotBlank(message = "Name is required")
        String name,

        int price,

        @NotBlank(message = "Url is required")
        String ImageUrl

) {
}
