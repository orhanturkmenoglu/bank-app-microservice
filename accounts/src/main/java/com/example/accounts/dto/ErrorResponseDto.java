package com.example.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Schema(
        name = "Error Response",
        description = "Schema to hold error response information"
)
public class ErrorResponseDto {

    @Schema(description = "API Path invoked by client")
    private String apiPath;
    @Schema(description = "Error Code")
    private HttpStatus errorCode;
    @Schema(description = "Error Message")
    private String errorMessage;
    @Schema(description = "Error Time")
    private LocalDateTime errorTime;

    public ErrorResponseDto(String apiPath, HttpStatus errorCode, String errorMessage, LocalDateTime errorTime) {
        this.apiPath = apiPath;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorTime = errorTime;
    }
}
