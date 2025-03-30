package co.edu.uceva.semestreservice.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "El semestre debe estar asociado a un programa academico")
    @Column(nullable = false)
    private long programaId;
    @NotNull(message = "Debe ingresar cual es el semestre")
    @Size(min = 1, max = 10, message = "El semestrea debe estar en un rango del 1 al 10")
    @Column(nullable = false)
    private long numeroSemestre;
}
