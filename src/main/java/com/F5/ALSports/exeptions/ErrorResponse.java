package com.F5.ALSports.exeptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
//import java.util.List;

@Getter
@Setter
public class ErrorResponse {
    private String messages;
    private LocalDateTime timestamp;

    public ErrorResponse(String messages) {
        this.messages = messages;
        this.timestamp = LocalDateTime.now();
    }
}