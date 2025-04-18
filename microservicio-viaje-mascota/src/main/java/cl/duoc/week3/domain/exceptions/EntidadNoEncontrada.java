package cl.duoc.week3.domain.exceptions;

public class EntidadNoEncontrada extends RuntimeException {
    public EntidadNoEncontrada(String entity,Long id) {
        super(
                String.format("%s con id %d no fue encontrado",entity, id)
        );
    }
}
