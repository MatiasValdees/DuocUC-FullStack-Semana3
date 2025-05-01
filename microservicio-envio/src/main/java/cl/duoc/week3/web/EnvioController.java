package cl.duoc.week3.web;

import cl.duoc.week3.domain.models.Envio;
import cl.duoc.week3.service.IEnvioService;
import cl.duoc.week3.web.dtos.EnvioCreateRequest;
import cl.duoc.week3.web.dtos.EnvioUpdateRequest;

import cl.duoc.week3.web.hateoas.EnvioModelAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import cl.duoc.week3.web.dtos.ResponseWrapper;
import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequestMapping("envios")
@RestController
public class EnvioController {

    private final IEnvioService service;
    private final EnvioModelAssembler assembler;

    public EnvioController(IEnvioService service, EnvioModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper<CollectionModel<EntityModel<Envio>>>> getAll() {
        List<EntityModel<Envio>> envioModels = service.findAll().stream()
                .map(assembler::toModel)
                .toList();

        CollectionModel<EntityModel<Envio>> collectionModel = CollectionModel.of(
                envioModels,
                linkTo(methodOn(EnvioController.class).getAll()).withSelfRel()
        );

        return ResponseEntity.ok(
                ResponseWrapper.<CollectionModel<EntityModel<Envio>>>builder()
                        .status("OK")
                        .timestamp(LocalDateTime.now())
                        .data(collectionModel)
                        .build()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper<EntityModel<Envio>>> getById(@PathVariable Long id) {
        Envio envio = service.findById(id);
        return ResponseEntity.ok(
                ResponseWrapper.<EntityModel<Envio>>builder()
                        .status("OK")
                        .timestamp(LocalDateTime.now())
                        .data(assembler.toModel(envio))
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper<EntityModel<Envio>>> create(@Valid @RequestBody EnvioCreateRequest request) {
        Envio created = service.create(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ResponseWrapper.<EntityModel<Envio>>builder()
                                .status("OK")
                                .timestamp(LocalDateTime.now())
                                .data(assembler.toModel(created))
                                .build()
                );
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper<EntityModel<Envio>>> update(@Valid @RequestBody EnvioUpdateRequest request) {
        Envio updated = service.update(request);
        return ResponseEntity.ok(
                ResponseWrapper.<EntityModel<Envio>>builder()
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
                        .data("Envio eliminado")
                        .build()
        );
    }
}
