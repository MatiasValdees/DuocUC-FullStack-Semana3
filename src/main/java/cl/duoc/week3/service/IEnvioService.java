
package cl.duoc.week3.service;

import cl.duoc.week3.domain.models.Envio;

import java.util.List;

public interface IEnvioService {
    Envio findById(Long id);
    List<Envio> findAll();
    List<Envio> findEmpty();
}
