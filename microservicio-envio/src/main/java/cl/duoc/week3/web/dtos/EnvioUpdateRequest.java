package cl.duoc.week3.web.dtos;

import cl.duoc.week3.domain.models.enums.EstadoEnvio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record EnvioUpdateRequest(
        @Positive
        @NotNull
        Long id,
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
        Long receptorId,
        @NotNull
        EstadoEnvio estado
) {
}
