package cl.duoc.week3.service;

import cl.duoc.week3.domain.exceptions.EmisorNoEncotrado;
import cl.duoc.week3.domain.exceptions.EnvioNoEncontrado;
import cl.duoc.week3.domain.exceptions.ListaVaciaException;
import cl.duoc.week3.domain.exceptions.ReceptorNoEncotrado;
import cl.duoc.week3.domain.models.Cliente;
import cl.duoc.week3.domain.models.Envio;
import cl.duoc.week3.domain.models.enums.EstadoEnvio;
import cl.duoc.week3.repository.IClienteRepository;
import cl.duoc.week3.repository.IEnvioRepository;
import cl.duoc.week3.web.dtos.EnvioCreateRequest;
import cl.duoc.week3.web.dtos.EnvioUpdateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EnvioServiceTest {


    @Mock
    private IEnvioRepository repository;
    @Mock
    private IClienteRepository clienteRepository;
    @InjectMocks
    private EnvioService envioService;


    @Test
    @DisplayName("Test Buscar por id - Exitoso")
    void findById() {
        // Given
        var envio = new Envio();
        envio.setId(1L);
        envio.setDireccion("Av. Siempre Viva 123");
        envio.setCiudad("Springfield");
        envio.setPais("USA");
        envio.setLongitud("-123.456");
        envio.setLatitud("45.678");
        envio.setEstado(EstadoEnvio.PENDIENTE);
        // When
        when(repository.findById(1L)).thenReturn(Optional.of(envio));
        //Then
        var result = envioService.findById(1L);
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
        assertThrows(EnvioNoEncontrado.class, () -> envioService.findById(idNotFound));
    }

    @Test
    void findAll() {
        // Given
        var envio1 = new Envio();
        envio1.setId(1L);
        envio1.setDireccion("Av. Siempre Viva 123");
        envio1.setCiudad("Springfield");
        envio1.setPais("USA");
        envio1.setLongitud("-123.456");
        envio1.setLatitud("45.678");
        envio1.setEstado(EstadoEnvio.PENDIENTE);

        var envio2 = new Envio();
        envio2.setId(2L);
        envio2.setDireccion("Calle Falsa 456");
        envio2.setCiudad("Springfield");
        envio2.setPais("USA");
        envio2.setLongitud("-123.456");
        envio2.setLatitud("45.678");
        envio2.setEstado(EstadoEnvio.PENDIENTE);

        // When
        when(repository.findAll()).thenReturn(List.of(envio1,envio2));
        // Then
        var result = envioService.findAll();
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void findAllEmpty() {
        // Given
        List<Envio>envios= List.of();
        // When
        when(repository.findAll()).thenReturn(envios);
        // Then
        assertThrows(ListaVaciaException.class, () -> envioService.findAll());
    }

    @Test
    @DisplayName("Test crear envio - Exitoso")
    void create() {
        // Given
        EnvioCreateRequest request = new EnvioCreateRequest(
                "Direccion",
                "Pais",
                "Ciudad",
                "123.456",
                "456.789",
                1L,
                2L
        );
        Cliente emisor = new Cliente();
        emisor.setId(1L);
        emisor.setRut("12345678-9");
        emisor.setNombres("Emisor");
        emisor.setApellidos("Apellido Emisor");

        Cliente receptor = new Cliente();
        receptor.setId(2L);
        receptor.setRut("98765432-1");
        receptor.setNombres("Receptor");
        receptor.setApellidos("Apellido Receptor");

        // When
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(emisor));
        when(clienteRepository.findById(2L)).thenReturn(Optional.of(receptor));
        when(repository.save(any())).thenReturn(new Envio());
        // Then
        var result=envioService.create(request);
        assertNotNull(result);
    }

    @Test
    @DisplayName("Test actualizar envio - Emisor NotFound")
    void updateEmisorNotFound() {
        // Given
        EnvioUpdateRequest request = new EnvioUpdateRequest(
                1L,
                "Direccion",
                "Pais",
                "Ciudad",
                "123.456",
                "456.789",
                1L,
                2L,
                EstadoEnvio.ENTREGADO
        );
        // When
        when(repository.findById(1L)).thenReturn(Optional.of(new Envio()));
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());
        // Then
        assertThrows(EmisorNoEncotrado.class, () -> envioService.update(request));
    }

    @Test
    @DisplayName("Test actualizar envio - Envio NotFound")
    void updateEnvioNotFound() {
        // Given
        EnvioUpdateRequest request = new EnvioUpdateRequest(
                1L,
                "Direccion",
                "Pais",
                "Ciudad",
                "123.456",
                "456.789",
                1L,
                2L,
                EstadoEnvio.ENTREGADO
        );
        // When
        when(repository.findById(1L)).thenReturn(Optional.empty());
        // Then
        assertThrows(EnvioNoEncontrado.class, () -> envioService.update(request));
    }

    @Test
    @DisplayName("Test actualizar envio - Receptor NotFound")
    void updateReceptorNotFound() {
        // Given
        EnvioUpdateRequest request = new EnvioUpdateRequest(
                1L,
                "Direccion",
                "Pais",
                "Ciudad",
                "123.456",
                "456.789",
                1L,
                2L,
                EstadoEnvio.ENTREGADO
        );
        // When
        when(repository.findById(1L)).thenReturn(Optional.of(new Envio()));
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(new Cliente()));
        when(clienteRepository.findById(2L)).thenReturn(Optional.empty());
        // Then
        assertThrows(ReceptorNoEncotrado.class, () -> envioService.update(request));
    }

    @Test
    @DisplayName("Test actualizar envio - Exitoso")
    void updateEnvio() {
        // Given
        EnvioUpdateRequest request = new EnvioUpdateRequest(
                1L,
                "Direccion",
                "Pais",
                "Ciudad",
                "123.456",
                "456.789",
                1L,
                2L,
                EstadoEnvio.ENTREGADO
        );
        // When
        when(repository.findById(1L)).thenReturn(Optional.of(new Envio()));
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(new Cliente()));
        when(clienteRepository.findById(2L)).thenReturn(Optional.of(new Cliente()));
        when(repository.save(any())).thenReturn(new Envio());
        // Then
        var result=envioService.update(request);
        assertNotNull(result);
    }


    @Test
    @DisplayName("Test eliminar envio - Exitoso")
    void delete() {
        // Given
        Long id= 1L;
        // When
        when(repository.findById(id)).thenReturn(Optional.of(new Envio()));
        // Then
        assertDoesNotThrow(() -> envioService.delete(id));
    }
}