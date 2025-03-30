package co.edu.uceva.semestreservice.domain.exception;

public class NoHaySemestresException extends RuntimeException {
    public NoHaySemestresException() {
        super("No hay semestres en la base de datos.");
    }
}
