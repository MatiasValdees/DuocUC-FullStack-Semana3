package cl.duoc.week3.domain.models.enums;

import lombok.Getter;

@Getter
public enum RolEnum {
    DUENO_MASCOTA("PASAJERO"),
    CONDUCTOR("CHOFER");

    private String descripcion;

    RolEnum(String descripcion) {
        this.descripcion = descripcion;
    }
}
