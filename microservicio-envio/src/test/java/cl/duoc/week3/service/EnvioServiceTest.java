package cl.duoc.week3.service;

import cl.duoc.week3.domain.exceptions.EnvioNoEncontrado;
import cl.duoc.week3.domain.models.Envio;
import cl.duoc.week3.domain.models.enums.EstadoEnvio;
import cl.duoc.week3.repository.IEnvioRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EnvioServiceTest {


    @Mock
    private IEnvioRepository repository;
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
        var exception = assertThrows(EnvioNoEncontrado.class, () -> envioService.findById(idNotFound));

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
}