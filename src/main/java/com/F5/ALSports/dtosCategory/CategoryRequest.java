package com.F5.ALSports.dtosCategory;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(@NotBlank(message = "Description is required") String name) {
}