package cl.duoc.week3.domain.models.enums;

import lombok.Getter;

@Getter
public enum RolEnum {
    DUENO_MASCOTA("Dueño de Mascota"),
    CONDUCTOR("Conductor de Transporte Pet-Friendly");

    private String descripcion;

    RolEnum(String descripcion) {
        this.descripcion = descripcion;
    }
}
