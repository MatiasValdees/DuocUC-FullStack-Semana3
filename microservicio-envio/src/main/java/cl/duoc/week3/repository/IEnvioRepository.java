package cl.duoc.week3.repository;

import cl.duoc.week3.domain.models.Envio;

import java.util.List;
import java.util.Optional;

public interface IEnvioRepository {
    
    Optional<Envio> findById(Long id);
    List<Envio> findAll();
    List<Envio> findEmpty();
}
