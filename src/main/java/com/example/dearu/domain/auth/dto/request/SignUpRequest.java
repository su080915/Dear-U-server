package com.example.dearu.domain.auth.dto.request;

import jakarta.validation.constraints.NotBlank;

public record SignUpRequest(
        @NotBlank
        String username,
        @NotBlank
        String name,
        @NotBlank
        String password,
        @NotBlank
        String studentNumber
) {
}
