package cl.duoc.week3.domain.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RolEnum {
    DUENO_MASCOTA("PASAJERO"),
    CONDUCTOR("CHOFER");

    private final String descripcion;

}
