package cl.duoc.week3.domain.models;

import cl.duoc.week3.domain.models.enums.EstadoEnvio;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Envio {
    private Long id;
    private String direccion;
    private String pais;
    private String ciudad;
    private Cliente emisor;
    private Cliente receptor;
    private String longitud;
    private String latitud;
    private EstadoEnvio estado;
}
