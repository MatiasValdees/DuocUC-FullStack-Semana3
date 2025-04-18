package cl.duoc.week3.repository;


import cl.duoc.week3.domain.models.Envio;
import org.springframework.data.repository.CrudRepository;

public interface IEnvioRepository extends CrudRepository<Envio, Long> {
}
