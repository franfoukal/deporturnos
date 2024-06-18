package com.project.deporturnos.exception;

import com.project.deporturnos.entity.dto.GeneralResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handlerArgumentException(IllegalArgumentException ex)
    {
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<GeneralResponseDTO> handlerResourceNotFoundException(ResourceNotFoundException ex)
    {
        return new ResponseEntity<GeneralResponseDTO>(new GeneralResponseDTO(ex.getMessage()),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handlerRuntimeException(RuntimeException ex)
    {
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(ForbiddenAccessException.class)
    public ResponseEntity<String> handlerForbiddenAccessException(RuntimeException ex)
    {
        return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    @ResponseBody
    public ResponseEntity<String> handleForbiddenException(Exception ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseBody
    public ResponseEntity<String> handleUnauthorizedException(Exception ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public ResponseEntity<String> handleAuthenticationException(Exception ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }
}
