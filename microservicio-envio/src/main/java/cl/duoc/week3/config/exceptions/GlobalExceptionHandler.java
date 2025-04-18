package cl.duoc.week3.config.exceptions;

import cl.duoc.week3.domain.exceptions.EnvioNoEncontrado;
import cl.duoc.week3.domain.exceptions.ListaVaciaException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

import cl.duoc.week3.domain.exceptions.EmisorNoEncotrado;
import cl.duoc.week3.domain.exceptions.ReceptorNoEncotrado;
import cl.duoc.week3.web.dtos.ResponseWrapper;

@ControllerAdvice
public class GlobalExceptionHandler {
        @ExceptionHandler(ListaVaciaException.class)
        public ResponseEntity<ResponseWrapper<ExceptionResponse<String>>> handlePeliculaNotFound(ListaVaciaException ex) {
                ExceptionResponse<String> response = ExceptionResponse.<String>builder()
                        .code("NOT_FOUND")
                        .message(ex.getMessage())
                        .build();
        
                ResponseWrapper<ExceptionResponse<String>> responseWrapper = ResponseWrapper.<ExceptionResponse<String>>builder()
                        .status("ERROR")
                        .timestamp(LocalDateTime.now())
                        .data(response)
                        .build();
        
                return new ResponseEntity<>(responseWrapper, HttpStatus.NOT_FOUND);
            }

        @ExceptionHandler(EnvioNoEncontrado.class)
        public ResponseEntity<ResponseWrapper<ExceptionResponse<String>>> handleEnvioNoEncontrado(EnvioNoEncontrado ex) {
                ExceptionResponse<String> response = ExceptionResponse.<String>builder()
                        .code("NOT_FOUND")
                        .message(ex.getMessage())
                        .build();
        
                ResponseWrapper<ExceptionResponse<String>> responseWrapper = ResponseWrapper.<ExceptionResponse<String>>builder()
                        .status("ERROR")
                        .timestamp(LocalDateTime.now())
                        .data(response)
                        .build();
        
                return new ResponseEntity<>(responseWrapper, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(EmisorNoEncotrado.class)
        public ResponseEntity<ResponseWrapper<ExceptionResponse<String>>> handleEmisorNoEncotrado(EmisorNoEncotrado ex) {
                ExceptionResponse<String> response = ExceptionResponse.<String>builder()
                        .code("NOT_FOUND")
                        .message(ex.getMessage())
                        .build();
        
                ResponseWrapper<ExceptionResponse<String>> responseWrapper = ResponseWrapper.<ExceptionResponse<String>>builder()
                        .status("ERROR")
                        .timestamp(LocalDateTime.now())
                        .data(response)
                        .build();
        
                return new ResponseEntity<>(responseWrapper, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(ReceptorNoEncotrado.class)
        public ResponseEntity<ResponseWrapper<ExceptionResponse<String>>> handleReceptorNoEncotrado(ReceptorNoEncotrado ex) {
                ExceptionResponse<String> response = ExceptionResponse.<String>builder()
                        .code("NOT_FOUND")
                        .message(ex.getMessage())
                        .build();
        
                ResponseWrapper<ExceptionResponse<String>> responseWrapper = ResponseWrapper.<ExceptionResponse<String>>builder()
                        .status("ERROR")
                        .timestamp(LocalDateTime.now())
                        .data(response)
                        .build();
        
                return new ResponseEntity<>(responseWrapper, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ResponseWrapper<ExceptionResponse<List<String>>>> handleMethodArgumentNotValidException(
                        MethodArgumentNotValidException ex) {

                List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                                .toList();

                ExceptionResponse<List<String>> response = ExceptionResponse.<List<String>>builder()
                                .code("VALIDATION_ERROR")
                                .message(errors)
                                .build();

                ResponseWrapper<ExceptionResponse<List<String>>> responseWrapper = ResponseWrapper
                                .<ExceptionResponse<List<String>>>builder()
                                .status("ERROR")
                                .timestamp(LocalDateTime.now())
                                .data(response)
                                .build();

                return new ResponseEntity<>(responseWrapper, HttpStatus.BAD_REQUEST);
        }
}
