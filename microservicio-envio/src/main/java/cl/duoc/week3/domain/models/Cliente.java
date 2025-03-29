package cl.duoc.week3.domain.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
    private String rut;
    private String nombres;
    private String apellidos;}
