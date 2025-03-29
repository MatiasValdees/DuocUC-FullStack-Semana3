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
    private String comuna;
    private Cliente cliente;
    private String latitud;
    private String longitud;
    private EstadoEnvio estado;
}
