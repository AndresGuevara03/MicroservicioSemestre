package co.edu.uceva.semestreservice.delivery.rest;

import co.edu.uceva.semestreservice.domain.model.Semestre;
import co.edu.uceva.semestreservice.domain.service.ISemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/semestre-service")
public class SemestreRestController {

    private ISemestreService productoService;

    public SemestreRestController(ISemestreService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/semestres")
    public List<Semestre> getSemestres(){
        return productoService.findAll();
    }

    @PostMapping("/semestres")
    public Semestre save(@RequestBody Semestre producto) {
        return productoService.save(producto);
    }

    @DeleteMapping("/semestres")
    public void delete(@RequestBody Semestre producto){
        productoService.delete(producto);
    }

    @PutMapping("/semestres")
    public Semestre update(@RequestBody Semestre producto){
        return productoService.update(producto);
    }

    @GetMapping("/semestres/{id}")
    public Semestre findById(@PathVariable("id") Long id){
        return productoService.findById(id).orElse(null);
    }
}
