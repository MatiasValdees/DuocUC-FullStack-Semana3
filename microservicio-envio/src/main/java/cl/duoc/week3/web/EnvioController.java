package cl.duoc.week3.web;

import cl.duoc.week3.domain.models.Envio;
import cl.duoc.week3.service.IEnvioService;
import cl.duoc.week3.web.dtos.EnvioCreateRequest;
import cl.duoc.week3.web.dtos.EnvioUpdateRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import cl.duoc.week3.web.dtos.ResponseWrapper;
import jakarta.validation.Valid;

@RequestMapping("envios")
@RestController
public class EnvioController {
    private final IEnvioService service;
    public EnvioController(IEnvioService service) {
        this.service = service;
    }

@GetMapping
    public ResponseEntity<ResponseWrapper<List<Envio>>> getAll() {
        return ResponseEntity.ok(
            ResponseWrapper.<List<Envio>>builder()
                .status("OK")
                .timestamp(LocalDateTime.now())
                .data(service.findAll())
                .build()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper<Envio>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
            ResponseWrapper.<Envio>builder()
                .status("OK")
                .timestamp(LocalDateTime.now())
                .data(service.findById(id))
                .build()
        );
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper<Envio>> create(@Valid @RequestBody EnvioCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            ResponseWrapper.<Envio>builder()
                .status("OK")
                .timestamp(LocalDateTime.now())
                .data(service.create(request))
                .build()
        );
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper<Envio>> update(@Valid @RequestBody EnvioUpdateRequest request) {
        return ResponseEntity.ok(
            ResponseWrapper.<Envio>builder()
                .status("OK")
                .timestamp(LocalDateTime.now())
                .data(service.update(request))
                .build()
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseWrapper<String>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(
            ResponseWrapper.<String>builder()
                .status("OK")
                .timestamp(LocalDateTime.now())
                .data("Envio eliminado")
                .build()
        );
    }

}
