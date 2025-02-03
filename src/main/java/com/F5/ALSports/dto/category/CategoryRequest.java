package com.F5.ALSports.dto.category;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(@NotBlank(message = "Name is required") String name) {
}