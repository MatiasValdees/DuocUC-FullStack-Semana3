
package cl.duoc.week3.service;

import cl.duoc.week3.domain.models.Envio;
import cl.duoc.week3.web.dtos.EnvioCreateRequest;
import cl.duoc.week3.web.dtos.EnvioUpdateRequest;

import java.util.List;

public interface IEnvioService {
    Envio findById(Long id);
    List<Envio> findAll();
    Envio create(EnvioCreateRequest request);
    Envio update (EnvioUpdateRequest request);
    void delete(Long id);
}
