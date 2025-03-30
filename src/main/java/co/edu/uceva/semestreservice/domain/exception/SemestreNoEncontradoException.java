package co.edu.uceva.semestreservice.domain.exception;

public class SemestreNoEncontradoException extends RuntimeException {
    public SemestreNoEncontradoException(Long id) {
        super("El semestre con ID " + id + " no fue encontrado.");
    }
}
