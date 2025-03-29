package cl.duoc.week3.repository;

import cl.duoc.week3.domain.models.Viaje;

import java.util.List;

public interface IViajeRepository {
    List<Viaje> findAll();
    List<Viaje> findEmpty();
    Viaje findById(Long id);
}
