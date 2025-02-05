package com.F5.ALSports.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {
    private List<String> messages;
    private LocalDateTime timestamp;

    public ErrorResponse(List<String> messages) {
        this.messages = messages;
        this.timestamp = LocalDateTime.now();
    }
}