package com.grupo3.app.config.Handler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private Integer status;
    private String message;
    private LocalDateTime timestamp;
}