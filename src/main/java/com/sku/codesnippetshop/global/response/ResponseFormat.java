package com.sku.codesnippetshop.global.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ResponseFormat <T> {

    private boolean isSuccessful;

    private Optional<T> data;

    private String message;

    private HttpStatus statusCode;

    public static <T> ResponseFormat<T> success(ResponseStatus responseStatus){

        return ResponseFormat.<T>builder()
                .isSuccessful(true)
                .data(Optional.empty())
                .message(responseStatus.getMessage())
                .statusCode(responseStatus.getStatusCode())
                .build();
    }

    public static <T> ResponseFormat<T> success(String message,
                                                HttpStatus status){

        return ResponseFormat.<T>builder()
                .isSuccessful(true)
                .data(Optional.empty())
                .message(message)
                .statusCode(status)
                .build();
    }

    public static <T> ResponseFormat<T> successWithData(ResponseStatus responseStatus,
                                                        T data){

        return ResponseFormat.<T>builder()
                .isSuccessful(true)
                .data(Optional.ofNullable(data))
                .message(responseStatus.getMessage())
                .statusCode(responseStatus.getStatusCode())
                .build();
    }
    

    public static <T> ResponseFormat<T> successWithData(String message,
                                                        HttpStatus status,
                                                        T data){

        return ResponseFormat.<T>builder()
                .isSuccessful(true)
                .data(Optional.ofNullable(data))
                .message(message)
                .statusCode(status)
                .build();
    }

    public static <T> ResponseFormat<T> error(ResponseStatus responseStatus){

        return ResponseFormat.<T>builder()
                .isSuccessful(false)
                .data(Optional.empty())
                .message(responseStatus.getMessage())
                .statusCode(responseStatus.getStatusCode())
                .build();
    }

    public static <T> ResponseFormat<T> error(String message,
                                              HttpStatus status){

        return ResponseFormat.<T>builder()
                .isSuccessful(false)
                .data(Optional.empty())
                .message(message)
                .statusCode(status)
                .build();
    }
}