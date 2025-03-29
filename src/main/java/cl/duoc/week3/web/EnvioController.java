package cl.duoc.week3.web;

import cl.duoc.week3.domain.models.Envio;
import cl.duoc.week3.service.IEnvioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("envios")
@RestController
@RequiredArgsConstructor
public class EnvioController {
    private final IEnvioService service;

    @GetMapping
    public ResponseEntity<List<Envio>>getAll(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("lista-vacia")
    public ResponseEntity<List<Envio>>getEmpty(){
        return ResponseEntity.ok(service.findEmpty());
    }

    @GetMapping("{id}")
    public ResponseEntity<Envio>getById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
}
