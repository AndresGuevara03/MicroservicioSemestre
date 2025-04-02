package co.edu.uceva.semestreservice.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "El semestre debe estar asociado a un programa academico")
    @Column(nullable = false)
    private long idPrograma;
    @NotNull(message = "Debe ingresar cual es el semestre")
    @Range(min = 1, max = 12, message = "El semestrea debe estar en un rango del 1 al 10")
    @Column(nullable = false)
    private Byte numeroSemestre;
    @NotNull(message = "Debe ingresar la fecha de inicio del semestre")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaInicio;
    @NotNull(message = "Debe ingresar la fecha de fin del semestre")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaFin;
    @Column(nullable = false)
    @NotNull(message = "Debe indicar si el programa se encuentra activo")
    private boolean activo;
}
