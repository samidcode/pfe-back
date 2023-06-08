package ma.payment.ws;
import ma.payment.bean.Eleve;
import ma.payment.exceptions.EntityNotFoundException;
import ma.payment.service.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api1/eleves")
public class EleveController {
    private final EleveService eleveService;

    @Autowired
    public EleveController(EleveService eleveService) {
        this.eleveService = eleveService;
    }

    @GetMapping
    public ResponseEntity<List<Eleve>> getAllEleves() {
        List<Eleve> eleves = eleveService.getAllEleves();
        return ResponseEntity.ok(eleves);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Eleve> getEleveById(@PathVariable int id) {
        Eleve eleve = eleveService.getEleveById(id)
                .orElseThrow(() -> new EntityNotFoundException("Eleve not found with ID: " + id));
        return ResponseEntity.ok(eleve);
    }

    @PostMapping
    public ResponseEntity<Eleve> createEleve(@RequestBody Eleve eleve) {
        Eleve createdEleve = eleveService.saveEleve(eleve);
        return new ResponseEntity<>(createdEleve, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Eleve> updateEleve(@PathVariable int id, @RequestBody Eleve eleve) {
        Eleve existingEleve = eleveService.getEleveById(id)
                .orElseThrow(() -> new EntityNotFoundException("Eleve not found with ID: " + id));
        eleve.setId(id);
        Eleve updatedEleve = eleveService.saveEleve(eleve);
        return ResponseEntity.ok(updatedEleve);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEleve(@PathVariable int id) {
        eleveService.deleteEleve(id);
        return ResponseEntity.noContent().build();
    }
}
