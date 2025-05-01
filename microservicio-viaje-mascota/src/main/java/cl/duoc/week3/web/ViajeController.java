package cl.duoc.week3.web;

import cl.duoc.week3.domain.models.Viaje;
import cl.duoc.week3.service.IViajeService;

import cl.duoc.week3.web.hateoas.ViajeModelAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RequestMapping("viajes")
@RestController
public class ViajeController {

    private final IViajeService service;
    private final ViajeModelAssembler assembler;

    public ViajeController(IViajeService service, ViajeModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<CollectionModel<EntityModel<Viaje>>>> getAll() {
        List<EntityModel<Viaje>> viajes = service.findAll().stream()
                .map(assembler::toModel)
                .toList();

        CollectionModel<EntityModel<Viaje>> collectionModel = CollectionModel.of(
                viajes,
                linkTo(methodOn(ViajeController.class).getAll()).withSelfRel()
        );

        return ResponseEntity.ok(
                ResponseWrapper.<CollectionModel<EntityModel<Viaje>>>builder()
                        .status("OK")
                        .timestamp(LocalDateTime.now())
                        .data(collectionModel)
                        .build()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper<EntityModel<Viaje>>> getById(@PathVariable Long id) {
        Viaje viaje = service.findById(id);
        return ResponseEntity.ok(
                ResponseWrapper.<EntityModel<Viaje>>builder()
                        .status("OK")
                        .timestamp(LocalDateTime.now())
                        .data(assembler.toModel(viaje))
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper<EntityModel<Viaje>>> create(@Valid @RequestBody ViajeCreateRequest request) {
        Viaje created = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ResponseWrapper.<EntityModel<Viaje>>builder()
                        .status("OK")
                        .timestamp(LocalDateTime.now())
                        .data(assembler.toModel(created))
                        .build()
        );
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper<EntityModel<Viaje>>> update(@Valid @RequestBody ViajeUpdateRequest request) {
        Viaje updated = service.update(request);
        return ResponseEntity.ok(
                ResponseWrapper.<EntityModel<Viaje>>builder()
                        .status("OK")
                        .timestamp(LocalDateTime.now())
                        .data(assembler.toModel(updated))
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

