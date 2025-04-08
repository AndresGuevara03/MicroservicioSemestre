package co.edu.uceva.semestreservice.domain.exception;

public class SemestreExistenteException extends RuntimeException {
    public SemestreExistenteException(long id) {
        super("El semestre con id " + id + " ya existe.");
    }
}
