package mx.edu.utez.proyecto1c.exception;

import mx.edu.utez.proyecto1c.exception.customExceptions.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {



    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String, String>> manejarBadRequest(
            BadRequestException ex) {

        Map<String, String> errores = new LinkedHashMap<>();
        errores.put("error", ex.getMessage());

        return ResponseEntity.badRequest().body(errores);
    }
}

