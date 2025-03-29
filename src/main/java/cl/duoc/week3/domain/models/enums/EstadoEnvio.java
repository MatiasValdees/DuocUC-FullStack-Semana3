package cl.duoc.week3.domain.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoEnvio {
    PENDIENTE("Pendiente"),
    EN_CAMINO("En Camino"),
    ENTREGADO("Entregado");

    private String estado;
}
