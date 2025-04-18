package cl.duoc.week3.domain.exceptions;

public class ReceptorNoEncotrado extends RuntimeException {
    public ReceptorNoEncotrado(Long id) {
        super(String.format("Receptor con id %s no encontrado", id));
    }
}
