package cl.duoc.week3.domain.exceptions;

public class ListaVaciaException extends RuntimeException {
    public ListaVaciaException(String entity) {
        super(String.format("La lista de %s está vacía", entity));
    }
}
