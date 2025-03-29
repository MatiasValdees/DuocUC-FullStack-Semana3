package cl.duoc.week3.domain.exceptions;

public class SinViajesException extends RuntimeException {
    public SinViajesException() {
        super("No hay viajes disponibles");
    }
}
