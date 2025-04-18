package cl.duoc.week3.config.exceptions;

import cl.duoc.week3.domain.exceptions.SinViajesException;
import cl.duoc.week3.domain.exceptions.EntidadNoEncontrada;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

import cl.duoc.week3.domain.exceptions.ViajeInvalido;
import cl.duoc.week3.web.dtos.ResponseWrapper;
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SinViajesException.class)
    public ResponseEntity<ResponseWrapper<ExceptionResponse<String>>> handleListaVacia(SinViajesException ex) {
        ExceptionResponse<String> exceptionResponse = ExceptionResponse.<String>builder()
                .code("SIN_VIAJES")
                .message(ex.getMessage())
                .build();

        ResponseWrapper<ExceptionResponse<String>> responseWrapper = ResponseWrapper.<ExceptionResponse<String>>builder()
                .status("NOT_FOUND")
                .timestamp(LocalDateTime.now())
                .data(exceptionResponse)
                .build();

        return new ResponseEntity<>(responseWrapper, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntidadNoEncontrada.class)
    public ResponseEntity<ResponseWrapper<ExceptionResponse<String>>> handleEnvioNoEncontrado(EntidadNoEncontrada ex) {
        ExceptionResponse<String> exceptionResponse = ExceptionResponse.<String>builder()
                .code("ENTIDAD_NO_ENCONTRADA")
                .message(ex.getMessage())
                .build();

        ResponseWrapper<ExceptionResponse<String>> responseWrapper = ResponseWrapper.<ExceptionResponse<String>>builder()
                .status("NOT_FOUND")
                .timestamp(LocalDateTime.now())
                .data(exceptionResponse)
                .build();

        return new ResponseEntity<>(responseWrapper, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ViajeInvalido.class)
    public ResponseEntity<ResponseWrapper<ExceptionResponse<String>>> handleViajeInvalido(ViajeInvalido ex) {
        ExceptionResponse<String> exceptionResponse = ExceptionResponse.<String>builder()
                .code("VIAJE_INVALIDO")
                .message(ex.getMessage())
                .build();

        ResponseWrapper<ExceptionResponse<String>> responseWrapper = ResponseWrapper.<ExceptionResponse<String>>builder()
                .status("NOT_FOUND")
                .timestamp(LocalDateTime.now())
                .data(exceptionResponse)
                .build();

        return new ResponseEntity<>(responseWrapper, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseWrapper<ExceptionResponse<List<String>>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

        ExceptionResponse<List<String>> exceptionResponse = ExceptionResponse.<List<String>>builder()
                .code("VALIDATION_ERROR")
                .message(errors)
                .build();

        ResponseWrapper<ExceptionResponse<List<String>>> responseWrapper = ResponseWrapper.<ExceptionResponse<List<String>>>builder()
                .status("BAD_REQUEST")
                .timestamp(LocalDateTime.now())
                .data(exceptionResponse)
                .build();

        return new ResponseEntity<>(responseWrapper, HttpStatus.BAD_REQUEST);
    }
}

