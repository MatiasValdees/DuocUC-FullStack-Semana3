package cl.duoc.week3.web.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record EnvioCreateRequest(
        @NotBlank
        String direccion,
        @NotBlank
        String pais,
        @NotBlank
        String ciudad,
        @NotBlank
        String longitud,
        @NotBlank
        String latitud,
        @Positive
        Long emisorId,
        @Positive
        Long receptorId
) {
}
