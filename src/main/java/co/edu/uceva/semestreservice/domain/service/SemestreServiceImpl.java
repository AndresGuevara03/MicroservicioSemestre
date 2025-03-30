package co.edu.uceva.semestreservice.domain.service;

import co.edu.uceva.semestreservice.domain.model.Semestre;
import co.edu.uceva.semestreservice.domain.repository.ISemestreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SemestreServiceImpl implements ISemestreService {
    ISemestreRepository repository;

    public SemestreServiceImpl(ISemestreRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Semestre save(Semestre producto) {
        return repository.save(producto);
    }

    @Override
    @Transactional
    public void delete(Semestre producto) {
        repository.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Semestre> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Semestre update(Semestre producto) {
        return repository.save(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Semestre> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Semestre> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
