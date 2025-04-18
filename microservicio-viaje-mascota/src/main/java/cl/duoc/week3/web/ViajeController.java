package cl.duoc.week3.web;

import cl.duoc.week3.domain.models.Viaje;
import cl.duoc.week3.service.IViajeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cl.duoc.week3.web.dtos.ResponseWrapper;
import cl.duoc.week3.web.dtos.ViajeCreateRequest;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;

import cl.duoc.week3.web.dtos.ViajeUpdateRequest;



@RequestMapping("viajes")
@RestController
public class ViajeController {
    private final IViajeService service;
    public ViajeController(IViajeService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<ResponseWrapper<List<Viaje>>> getAll() {
        return ResponseEntity.ok(
            ResponseWrapper.<List<Viaje>>builder()
                .status("OK")
                .timestamp(LocalDateTime.now())
                .data(service.findAll())
                .build()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper<Viaje>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
            ResponseWrapper.<Viaje>builder()
                .status("OK")
                .timestamp(LocalDateTime.now())
                .data(service.findById(id))
                .build()
        );
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper<Viaje>> create(@Valid @RequestBody ViajeCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            ResponseWrapper.<Viaje>builder()
                .status("OK")
                .timestamp(LocalDateTime.now())
                .data(service.create(request))
                .build()
        );
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper<Viaje>> update(@Valid @RequestBody ViajeUpdateRequest request) {
        return ResponseEntity.ok(
            ResponseWrapper.<Viaje>builder()
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
                .data("Viaje eliminado")
                .build()
        );
    }
    
}
