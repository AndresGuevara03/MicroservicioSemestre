package co.edu.uceva.semestreservice.delivery.rest;

import co.edu.uceva.semestreservice.domain.exception.*;
import co.edu.uceva.semestreservice.domain.model.Semestre;
import co.edu.uceva.semestreservice.domain.service.IProgramaClient;
import co.edu.uceva.semestreservice.domain.service.ISemestreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/semestre-service")
public class SemestreRestController {
    private final ISemestreService semestreService;
    private final IProgramaClient programaClient;

    private static final String MENSAJE = "mensaje";
    private static final String SEMESTRE = "semestre";
    private static final String SEMESTRES = "semestres";

    @Autowired
    public SemestreRestController(ISemestreService semestreService, IProgramaClient programaClient) {
        this.semestreService = semestreService;
        this.programaClient = programaClient;
    }

    @GetMapping("/semestres")
    public ResponseEntity<Map<String, Object>> getSemestres() {
        Map<String, Object> response = new HashMap<>();
        List<Semestre> semestres = semestreService.findAll();
        if (semestres.isEmpty()) {
            throw new NoHaySemestresException();
        }
        response.put(SEMESTRES, semestres);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/programas")
    public ResponseEntity<Map<String, Object>> getProgramas() {
        return programaClient.getProgramas();
    }

    @GetMapping("/semestre/page/{page}")
    public ResponseEntity<Object> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        Page<Semestre> semestres = semestreService.findAll(pageable);
        if (semestres.isEmpty()) {
            throw new PaginaSinSemestresException(page);
        }
        return ResponseEntity.ok(semestres);
    }

    @PostMapping("/semestres")
    public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody Semestre semestre, BindingResult bindingResult) {
        Map<String, Object> response = new HashMap<>();
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }
        if (semestre.getId() != null &&
                semestreService.findById(semestre.getId()).orElse(null) != null) {
            throw new SemestreExistenteException(semestre.getId());
        }
        Semestre nuevoSemestre = semestreService.save(semestre);
        response.put(MENSAJE, "El semestre ha sido creado con éxito!");
        response.put(SEMESTRE, nuevoSemestre);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/semestres")
    public ResponseEntity<Map<String, Object>> delete(@RequestBody Semestre semestre) {
        Map<String, Object> response = new HashMap<>();
        semestreService.findById(semestre.getId()).orElseThrow(
                () -> new SemestreNoEncontradoException(semestre.getId())
        );
        semestreService.delete(semestre);
        response.put(MENSAJE, "El semestre ha sido eliminado con éxito!");
        response.put(SEMESTRE, null);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/semestres")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody Semestre semestre, BindingResult bindingResult) {
        Map<String, Object> response = new HashMap<>();
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }
        semestreService.findById(semestre.getId()).orElseThrow(
                () -> new SemestreNoEncontradoException(semestre.getId())
        );
        Semestre semestreActualizado = semestreService.update(semestre);
        response.put(MENSAJE, "El semestre ha sido actualizado con éxito!");
        response.put(SEMESTRE, semestreActualizado);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/semestres/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Semestre semestre = semestreService.findById(id).orElseThrow(
                () -> new SemestreNoEncontradoException(id)
        );
        response.put(MENSAJE, "El semestre ha sido encontrado!");
        response.put(SEMESTRE, semestre);
        return ResponseEntity.ok(response);
    }
}
