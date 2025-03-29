package cl.duoc.week3.domain.exceptions;

public class ViajeNoEncontrado extends RuntimeException {
    public ViajeNoEncontrado(Long id) {
        super(
                String.format("El viaje con id %d no fue encontrado", id)
        );
    }
}
