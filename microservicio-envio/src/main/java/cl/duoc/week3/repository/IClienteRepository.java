package cl.duoc.week3.repository;

import cl.duoc.week3.domain.models.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteRepository extends CrudRepository<Cliente,Long> {
}
