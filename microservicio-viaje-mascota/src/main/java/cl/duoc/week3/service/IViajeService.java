package cl.duoc.week3.service;

import cl.duoc.week3.domain.models.Viaje;

import java.util.List;

import cl.duoc.week3.web.dtos.ViajeCreateRequest;
import cl.duoc.week3.web.dtos.ViajeUpdateRequest;

public interface IViajeService {
    List<Viaje> findAll();
    Viaje findById(Long id);
    Viaje create(ViajeCreateRequest request);
    Viaje update (ViajeUpdateRequest request);
    void delete(Long id);
}
