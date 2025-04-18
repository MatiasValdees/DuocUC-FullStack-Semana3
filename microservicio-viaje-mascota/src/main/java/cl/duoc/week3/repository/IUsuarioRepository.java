package cl.duoc.week3.repository;

import org.springframework.data.repository.CrudRepository;

import cl.duoc.week3.domain.models.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long>{

}
