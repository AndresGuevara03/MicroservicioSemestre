package co.edu.uceva.semestreservice.domain.exception;

public class SemestreExistenteException extends RuntimeException {
    public SemestreExistenteException(String nombre) {
        super("El semestre con nombre '" + nombre + "' ya existe.");
    }
}
