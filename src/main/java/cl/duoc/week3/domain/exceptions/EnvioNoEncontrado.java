package cl.duoc.week3.domain.exceptions;

public class EnvioNoEncontrado extends RuntimeException {
    public EnvioNoEncontrado(Long id) {
        super(String.format("Envío con id %s no encontrado", id));
    }
}
