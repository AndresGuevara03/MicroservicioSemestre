package co.edu.uceva.semestreservice.domain.repository;

import co.edu.uceva.semestreservice.domain.model.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISemestreRepository extends JpaRepository<Semestre, Long> {
}
