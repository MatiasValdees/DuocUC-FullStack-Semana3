package cl.duoc.week3.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private String rut;
    private String nombres;
    private String apellidos;
    private Mascota mascota;
    private String rol;
}
