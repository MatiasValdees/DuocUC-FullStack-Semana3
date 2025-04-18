package cl.duoc.week3.web.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ViajeUpdateRequest(
    @Positive
    @NotNull
    Long id,
    @NotBlank
    String direccion,
    @NotBlank
    String ciudad,
    @Positive
    @NotNull
    Long idChofer,
    @Positive
    @NotNull
    Long idPasajero
) {

}
