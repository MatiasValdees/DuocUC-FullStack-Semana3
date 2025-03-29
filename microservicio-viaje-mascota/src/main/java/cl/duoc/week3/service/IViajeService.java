package cl.duoc.week3.service;

import cl.duoc.week3.domain.models.Viaje;

import java.util.List;

public interface IViajeService {
    List<Viaje> findAll();
    List<Viaje> findEmpty();
    Viaje findById(Long id);
}
