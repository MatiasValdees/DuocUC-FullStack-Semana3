package cl.duoc.week3.service;

import cl.duoc.week3.domain.exceptions.SinViajesException;
import cl.duoc.week3.domain.exceptions.ViajeNoEncontrado;
import cl.duoc.week3.domain.models.Viaje;
import cl.duoc.week3.repository.IViajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViajeService implements IViajeService{
    private final IViajeRepository repository;

    @Override
    public List<Viaje> findAll() {
        List<Viaje> viajes = repository.findAll();
        if (viajes.isEmpty()){
            throw new SinViajesException();
        }
        return viajes;
    }

    @Override
    public List<Viaje> findEmpty() {
        List<Viaje> viajes = repository.findEmpty();
        if (viajes.isEmpty()){
            throw new SinViajesException();
        }
        return viajes;
    }

    @Override
    public Viaje findById(Long id) {
        Viaje viaje= repository.findById(id);
        if (viaje==null){
            throw new ViajeNoEncontrado(id);
        }
        return viaje;
    }
}
