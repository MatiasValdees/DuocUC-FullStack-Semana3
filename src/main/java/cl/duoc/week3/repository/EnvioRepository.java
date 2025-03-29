package cl.duoc.week3.repository;

import cl.duoc.week3.domain.models.Cliente;
import cl.duoc.week3.domain.models.Envio;
import cl.duoc.week3.domain.models.enums.EstadoEnvio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EnvioRepository implements IEnvioRepository {

    public Optional<Envio> findById(Long id) {
        return getList().stream().filter(e->e.getId().equals(id)).findFirst();
    }

    public List<Envio> findAll() {
        return getList();
    }

    public List<Envio> findEmpty() {
        return List.of();
    }

    private List<Envio> getList() {
        return Arrays.asList(
                Envio.builder()
                        .id(1L)
                        .direccion("Av. Libertador Bernardo O'Higgins 1234")
                        .comuna("Santiago")
                        .cliente(new Cliente("12.345.678-9", "Juan", "Pérez"))
                        .latitud("-33.4489")
                        .longitud("-70.6693")
                        .estado(EstadoEnvio.PENDIENTE)
                        .build(),

                Envio.builder()
                        .id(2L)
                        .direccion("Calle Los Aromos 456")
                        .comuna("Providencia")
                        .cliente(new Cliente("98.765.432-1", "María", "González"))
                        .latitud("-33.4263")
                        .longitud("-70.6106")
                        .estado(EstadoEnvio.EN_CAMINO)
                        .build(),

                Envio.builder()
                        .id(3L)
                        .direccion("Av. Vitacura 7890")
                        .comuna("Vitacura")
                        .cliente(new Cliente("15.123.456-7", "Pedro", "Martínez"))
                        .latitud("-33.3973")
                        .longitud("-70.5874")
                        .estado(EstadoEnvio.ENTREGADO)
                        .build(),

                Envio.builder()
                        .id(4L)
                        .direccion("Calle San Diego 101")
                        .comuna("Santiago Centro")
                        .cliente(new Cliente("17.654.321-8", "Ana", "López"))
                        .latitud("-33.4523")
                        .longitud("-70.6467")
                        .estado(EstadoEnvio.PENDIENTE)
                        .build(),

                Envio.builder()
                        .id(5L)
                        .direccion("Pasaje El Alba 789")
                        .comuna("La Florida")
                        .cliente(new Cliente("11.223.334-5", "Luis", "Ramírez"))
                        .latitud("-33.5211")
                        .longitud("-70.5804")
                        .estado(EstadoEnvio.EN_CAMINO)
                        .build(),

                Envio.builder()
                        .id(6L)
                        .direccion("Av. Apoquindo 4567")
                        .comuna("Las Condes")
                        .cliente(new Cliente("22.334.556-7", "Carla", "Méndez"))
                        .latitud("-33.4112")
                        .longitud("-70.5798")
                        .estado(EstadoEnvio.ENTREGADO)
                        .build(),

                Envio.builder()
                        .id(7L)
                        .direccion("Calle Manuel Montt 333")
                        .comuna("Providencia")
                        .cliente(new Cliente("18.456.789-0", "Diego", "Salazar"))
                        .latitud("-33.4318")
                        .longitud("-70.6154")
                        .estado(EstadoEnvio.PENDIENTE)
                        .build(),

                Envio.builder()
                        .id(8L)
                        .direccion("Av. Irarrázaval 999")
                        .comuna("Ñuñoa")
                        .cliente(new Cliente("19.876.543-2", "Paula", "Castillo"))
                        .latitud("-33.4547")
                        .longitud("-70.6051")
                        .estado(EstadoEnvio.EN_CAMINO)
                        .build());
    }
}
