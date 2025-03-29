package cl.duoc.week3.config.exceptions;

import cl.duoc.week3.domain.exceptions.EnvioNoEncontrado;
import cl.duoc.week3.domain.exceptions.ListaVaciaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
     @ExceptionHandler(ListaVaciaException.class)
     public ResponseEntity<ExceptionResponse> handleListaVacia(ListaVaciaException ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ExceptionResponse
                            .builder()
                            .timestamp(LocalDateTime.now())
                            .status(HttpStatus.NOT_FOUND.value())
                            .message(ex.getMessage())
                            .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                            .build());
     }

    @ExceptionHandler(EnvioNoEncontrado.class)
    public ResponseEntity<ExceptionResponse> handleEnvioNoEncontrado(EnvioNoEncontrado ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ExceptionResponse
                        .builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(ex.getMessage())
                        .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                        .build());
    }
}
