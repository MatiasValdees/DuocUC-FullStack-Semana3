package cl.duoc.week3.domain.exceptions;

public class EmisorNoEncotrado extends RuntimeException {
    public EmisorNoEncotrado(Long id) {
        super(String.format("Emisor con id %s no encontrado", id));
    }
}
