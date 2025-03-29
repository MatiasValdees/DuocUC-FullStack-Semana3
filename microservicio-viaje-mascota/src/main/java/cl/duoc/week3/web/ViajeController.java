package cl.duoc.week3.web;

import cl.duoc.week3.domain.models.Viaje;
import cl.duoc.week3.service.IViajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("viajes")
@RestController
@RequiredArgsConstructor
public class ViajeController {
    private final IViajeService service;

    @GetMapping
    public ResponseEntity<List<Viaje>>getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("lista-vacia")
    public ResponseEntity<List<Viaje>>getEmpty(){
        return ResponseEntity.ok(service.findEmpty());
    }
    @GetMapping("{id}")
    public ResponseEntity<Viaje>getById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
}
