package cl.duoc.week3.config.exceptions;

import cl.duoc.week3.domain.exceptions.SinViajesException;
import cl.duoc.week3.domain.exceptions.ViajeNoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
     @ExceptionHandler(SinViajesException.class)
     public ResponseEntity<ExceptionResponse> handleListaVacia(SinViajesException ex) {
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

    @ExceptionHandler(ViajeNoEncontrado.class)
    public ResponseEntity<ExceptionResponse> handleEnvioNoEncontrado(ViajeNoEncontrado ex) {
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
