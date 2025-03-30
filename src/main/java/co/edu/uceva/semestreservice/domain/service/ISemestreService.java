package co.edu.uceva.semestreservice.domain.service;

import co.edu.uceva.semestreservice.domain.model.Semestre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ISemestreService {
    Semestre save(Semestre producto);
    void delete(Semestre producto);
    Optional<Semestre> findById(Long id);
    Semestre update(Semestre producto);
    List<Semestre> findAll();
    Page<Semestre> findAll(Pageable pageable);
}
