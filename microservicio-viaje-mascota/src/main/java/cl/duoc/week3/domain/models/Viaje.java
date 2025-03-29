package cl.duoc.week3.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Viaje {
    private Long id;
    private String direccion;
    private String ciudad;
    private List<Usuario>usuarios;
}
