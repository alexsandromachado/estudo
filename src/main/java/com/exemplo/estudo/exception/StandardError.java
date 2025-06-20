package com.exemplo.estudo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError{

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
