
package cl.duoc.week3.service;

import cl.duoc.week3.domain.exceptions.EnvioNoEncontrado;
import cl.duoc.week3.domain.exceptions.ListaVaciaException;
import cl.duoc.week3.domain.models.Envio;
import cl.duoc.week3.repository.IEnvioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnvioService implements IEnvioService{
    private final IEnvioRepository repository;

    @Override
    public Envio findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EnvioNoEncontrado(id));
    }

    @Override
    public List<Envio> findAll() {
        List<Envio> envios= repository.findAll();
        if(envios.isEmpty()){
            throw new ListaVaciaException("Envíos");
        }
        return envios;
    }

    @Override
    public List<Envio> findEmpty() {
        List<Envio> envios= repository.findEmpty();
        if(envios.isEmpty()){
            throw new ListaVaciaException("Envíos");
        }
        return envios;
    }

}
