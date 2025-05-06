package cl.duoc.week3.service;

import cl.duoc.week3.domain.exceptions.EntidadNoEncontrada;
import cl.duoc.week3.domain.exceptions.SinViajesException;
import cl.duoc.week3.domain.exceptions.ViajeInvalido;
import cl.duoc.week3.domain.models.Usuario;
import cl.duoc.week3.domain.models.Viaje;
import cl.duoc.week3.domain.models.enums.RolEnum;
import cl.duoc.week3.repository.IUsuarioRepository;
import cl.duoc.week3.repository.IViajeRepository;
import cl.duoc.week3.web.dtos.ViajeCreateRequest;
import cl.duoc.week3.web.dtos.ViajeUpdateRequest;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ViajeServiceTest {

    @Mock
    private IViajeRepository repository;
    @Mock
    private IUsuarioRepository usuarioRepository;
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
    @DisplayName("Test obtener todos los viajes - Exitoso")
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
    @Test
    @DisplayName("Test obtener todos los viajes - Vacio")
    void findAllEmpty() {
        // Given
        List<Viaje> viajes = List.of();
        // When
        when(repository.findAll()).thenReturn(viajes);
        // Then
        assertThrows(SinViajesException.class, () -> viajeService.findAll());
    }

    @Test
    @DisplayName("Test eliminar viaje - Exitoso")
    void delete() {
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
        // Then
        assertDoesNotThrow(() -> viajeService.delete(1L));
    }

    @Test
    @DisplayName("Test eliminar viaje - Not Found")
    void deleteNotFound() {
        // Given
        Long idNotFound = 1L;
        // When
        when(repository.findById(1L)).thenReturn(Optional.empty());
        // Then
        assertThrows(EntidadNoEncontrada.class, () -> viajeService.delete(idNotFound));
    }
    @Test
    @DisplayName("Test crear viaje - Exitoso")
    void create() {
        // Given
        Usuario chofer = new Usuario();
        chofer.setId(1L);
        chofer.setNombres("Juan Juan");
        chofer.setRol(RolEnum.CONDUCTOR.getDescripcion());

        Usuario pasajero = new Usuario();
        pasajero.setId(2L);
        pasajero.setNombres("María María");
        pasajero.setRol(RolEnum.DUENO_MASCOTA.getDescripcion());

        Viaje viaje = new Viaje();
        viaje.setId(1L);
        viaje.setDireccion("Av. 123");
        viaje.setCiudad("Springfield");
        viaje.setChofer(chofer);
        viaje.setPasajero(pasajero);
        viaje.setFechaCreacion(LocalDateTime.now());

        ViajeCreateRequest request= new ViajeCreateRequest(
                "Av. 123",
                "Springfield",
                1L,
                2L
        );
        // When
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(chofer));
        when(usuarioRepository.findById(2L)).thenReturn(Optional.of(pasajero));
        when(repository.save(any())).thenReturn(viaje);
        // Then
        var result = viajeService.create(request);
        assertNotNull(result);
    }

    @Test
    @DisplayName("Test crear viaje - chofer no encontrado")
    void createChoferNotFound() {
        // Given
        ViajeCreateRequest request= new ViajeCreateRequest(
                "Av. 123",
                "Springfield",
                10L,
                2L
        );
        // When
        when(usuarioRepository.findById(10L)).thenReturn(Optional.empty());
        // Then
       assertThrows(EntidadNoEncontrada.class, () -> viajeService.create(request));
    }
    @Test
    @DisplayName("Test crear viaje - pasajero no encontrado")
    void createPasajeroNotFound() {
        // Given
        Usuario chofer = new Usuario();
        chofer.setId(1L);
        chofer.setNombres("Juan Juan");
        chofer.setRol(RolEnum.CONDUCTOR.getDescripcion());

        ViajeCreateRequest request= new ViajeCreateRequest(
                "Av. 123",
                "Springfield",
                1L,
                10L
        );
        // When
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(chofer));
        when(usuarioRepository.findById(10L)).thenReturn(Optional.empty());
        // Then
        assertThrows(EntidadNoEncontrada.class, () -> viajeService.create(request));
    }

    @Test
    @DisplayName("Test crear viaje - sin rol chofer")
    void createChoferNotIsChofer() {
        // Given
        Usuario chofer = new Usuario();
        chofer.setId(1L);
        chofer.setNombres("Juan Juan");
        chofer.setRol(RolEnum.DUENO_MASCOTA.getDescripcion());

        Usuario pasajero = new Usuario();
        pasajero.setId(2L);
        pasajero.setNombres("María María");
        pasajero.setRol(RolEnum.DUENO_MASCOTA.getDescripcion());

        ViajeCreateRequest request= new ViajeCreateRequest(
                "Av. 123",
                "Springfield",
                1L,
                2L
        );
        // When
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(chofer));
        when(usuarioRepository.findById(2L)).thenReturn(Optional.of(pasajero));
        // Then
        assertThrows(ViajeInvalido.class, () -> viajeService.create(request));
    }

    @Test
    @DisplayName("Test crear viaje - sin rol pasajero")
    void createPasajeroIsNotPasajeto() {
        // Given
        Usuario chofer = new Usuario();
        chofer.setId(1L);
        chofer.setNombres("Juan Juan");
        chofer.setRol(RolEnum.CONDUCTOR.getDescripcion());

        Usuario pasajero = new Usuario();
        pasajero.setId(2L);
        pasajero.setNombres("María María");
        pasajero.setRol(RolEnum.CONDUCTOR.getDescripcion());

        ViajeCreateRequest request= new ViajeCreateRequest(
                "Av. 123",
                "Springfield",
                1L,
                2L
        );
        // When
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(chofer));
        when(usuarioRepository.findById(2L)).thenReturn(Optional.of(pasajero));
        // Then
        assertThrows(ViajeInvalido.class, () -> viajeService.create(request));
    }

    @Test
    @DisplayName("Test actualizar viaje - Exitoso")
    void update() {
        // Given
        Usuario chofer = new Usuario();
        chofer.setId(1L);
        chofer.setNombres("Juan Juan");
        chofer.setRol(RolEnum.CONDUCTOR.getDescripcion());

        Usuario pasajero = new Usuario();
        pasajero.setId(2L);
        pasajero.setNombres("María María");
        pasajero.setRol(RolEnum.DUENO_MASCOTA.getDescripcion());

        Viaje viaje = new Viaje();
        viaje.setId(1L);
        viaje.setDireccion("Av. 123");
        viaje.setCiudad("Springfield");
        viaje.setChofer(chofer);
        viaje.setPasajero(pasajero);
        viaje.setFechaCreacion(LocalDateTime.now());

        ViajeUpdateRequest request= new ViajeUpdateRequest(
                1L,
                "Av. 123",
                "Springfield",
                1L,
                2L
        );
        // When
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(chofer));
        when(usuarioRepository.findById(2L)).thenReturn(Optional.of(pasajero));
        when(repository.findById(1L)).thenReturn(Optional.of(viaje));
        when(repository.save(any())).thenReturn(viaje);
        // Then
        var result = viajeService.update(request);
        assertNotNull(result);
    }

    @Test
    @DisplayName("Test actualizar viaje - Viaje no encontrado")
    void updateViajeNotFound() {
        // Given
        ViajeUpdateRequest request= new ViajeUpdateRequest(
                1L,
                "Av. 123",
                "Springfield",
                1L,
                2L
        );
        // When
        when(repository.findById(1L)).thenReturn(Optional.empty());
        // Then
        assertThrows(EntidadNoEncontrada.class, () -> viajeService.update(request));
    }


}