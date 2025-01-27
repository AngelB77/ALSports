package com.F5.ALSports.dto.category;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(@NotBlank(message = "Description is required") String name) {
}