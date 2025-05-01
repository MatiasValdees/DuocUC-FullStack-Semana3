package cl.duoc.week3.service;

import cl.duoc.week3.domain.exceptions.EntidadNoEncontrada;
import cl.duoc.week3.domain.models.Usuario;
import cl.duoc.week3.domain.models.Viaje;
import cl.duoc.week3.repository.IViajeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ViajeServiceTest {

    @Mock
    private IViajeRepository repository;
    @InjectMocks
    private ViajeService viajeService;


    @Test
    @DisplayName("Test Buscar por id - Exitoso")
    void findById() {
        // Given
        Usuario chofer = new Usuario();
        chofer.setId(1L);
        chofer.setNombres("Juan Juan");

        Usuario pasajero = new Usuario();
        pasajero.setId(2L);
        pasajero.setNombres("María María");

        Viaje viaje = new Viaje();
        viaje.setId(1L);
        viaje.setDireccion("Av. 123");
        viaje.setCiudad("Springfield");
        viaje.setChofer(chofer);
        viaje.setPasajero(pasajero);
        viaje.setFechaCreacion(LocalDateTime.now());

        // When
        when(repository.findById(1L)).thenReturn(Optional.of(viaje));
        //Then
        var result = viajeService.findById(1L);
        assertNotNull(result);

    }

    @Test
    @DisplayName("Test Buscar por id - Not Found")
    void findByIdNotFound() {
        //Given
        Long idNotFound= 1L;
        //when
        when(repository.findById(1L)).thenReturn(Optional.empty());
        //Then
        assertThrows(EntidadNoEncontrada.class, () -> viajeService.findById(idNotFound));

    }

    @Test
    void findAll() {
        // Given
        Usuario chofer = new Usuario();
        chofer.setId(1L);
        chofer.setNombres("Juan Juan");

        Usuario pasajero = new Usuario();
        pasajero.setId(2L);
        pasajero.setNombres("María María");

        Viaje viaje = new Viaje();
        viaje.setId(1L);
        viaje.setDireccion("Av. 123");
        viaje.setCiudad("Springfield");
        viaje.setChofer(chofer);
        viaje.setPasajero(pasajero);
        viaje.setFechaCreacion(LocalDateTime.now());
        // When
        when(repository.findAll()).thenReturn(List.of(viaje));
        // Then
        var result = viajeService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
    }
}