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
                        .direccion("Av. Bernard 1234")
                        .ciudad("Santiago")
                        .pais("Chile")
                        .emisor(new Cliente("12.345.678-9", "Juan", "Pérez"))
                        .receptor(new Cliente("11.111.111-1", "Matias", "Valdés"))
                        .latitud("-33.4489")
                        .longitud("-70.6693")
                        .estado(EstadoEnvio.PENDIENTE)
                        .build(),

                Envio.builder()
                        .id(2L)
                        .direccion("Calle Los Aromos 456")
                        .ciudad("Curico")
                        .pais("Chile")
                        .emisor(new Cliente("98.765.432-1", "María", "González"))
                        .receptor(new Cliente("11.111.111-0", "Matias", "reyes"))
                        .latitud("-33.4263")
                        .longitud("-70.6106")
                        .estado(EstadoEnvio.EN_CAMINO)
                        .build(),

                Envio.builder()
                        .id(3L)
                        .direccion("Av. Talca 7890")
                        .ciudad("Talca")
                        .pais("Chile")
                        .receptor(new Cliente("11.111.111-1", "Matias", "Valdés"))
                        .emisor(new Cliente("15.123.456-7", "Marina", "Reyes"))
                        .latitud("-33.3973")
                        .longitud("-70.5874")
                        .estado(EstadoEnvio.ENTREGADO)
                        .build(),

                Envio.builder()
                        .id(4L)
                        .direccion("Calle San Diego 101")
                        .ciudad("Santiago")
                        .pais("Chile")
                        .receptor(new Cliente("11.111.111-9", "Patricia", "Reyes"))
                        .emisor(new Cliente("17.654.321-8", "Ana", "López"))
                        .latitud("-33.4523")
                        .longitud("-70.6467")
                        .estado(EstadoEnvio.PENDIENTE)
                        .build(),

                Envio.builder()
                        .id(5L)
                        .direccion("Pasaje El Alba 789")
                        .ciudad("Viña del mar")
                        .pais("Chile")
                        .emisor(new Cliente("11.223.334-5", "Luis", "Ramírez"))
                        .receptor(new Cliente("11.111.111-1", "Juan", "Valdés"))
                        .latitud("-33.5211")
                        .longitud("-70.5804")
                        .estado(EstadoEnvio.EN_CAMINO)
                        .build(),

                Envio.builder()
                        .id(6L)
                        .direccion("Av. Apoquindo 4567")
                        .ciudad("Atacama")
                        .pais("Chile")
                        .receptor(new Cliente("11.111.111-1", "Nicolas", "Valdés"))
                        .emisor(new Cliente("22.334.556-7", "Carla", "Méndez"))
                        .latitud("-33.4112")
                        .longitud("-70.5798")
                        .estado(EstadoEnvio.ENTREGADO)
                        .build(),

                Envio.builder()
                        .id(7L)
                        .direccion("Calle Manuel Montt 333")
                        .ciudad("Osorno")
                        .pais("Chile")
                        .receptor(new Cliente("11.111.111-1", "Enrique", "Valdés"))
                        .emisor(new Cliente("18.456.789-0", "Diego", "Salazar"))
                        .latitud("-33.4318")
                        .longitud("-70.6154")
                        .estado(EstadoEnvio.PENDIENTE)
                        .build(),

                Envio.builder()
                        .id(8L)
                        .direccion("Av. hola 999")
                        .ciudad("Punta Arenas")
                        .pais("Chile")
                        .receptor(new Cliente("11.111.111-1", "Matias", "Valdés"))
                        .emisor(new Cliente("19.876.543-2", "Paula", "Castillo"))
                        .latitud("-33.4547")
                        .longitud("-70.6051")
                        .estado(EstadoEnvio.EN_CAMINO)
                        .build());
    }
}
