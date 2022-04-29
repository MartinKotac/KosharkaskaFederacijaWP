package ukim.finki.mk.kosharkaskafederacija.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.mk.kosharkaskafederacija.model.Referee;
import ukim.finki.mk.kosharkaskafederacija.model.dto.RefereeDto;
import ukim.finki.mk.kosharkaskafederacija.service.RefereeService;

import java.util.List;

@RestController
@RequestMapping("/api/referees")
public class RefereeRestController {
    private final RefereeService refereeService;

    public RefereeRestController(RefereeService refereeService) {
        this.refereeService = refereeService;
    }

    @GetMapping
    public List<Referee> findAll() {
        return refereeService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Referee> findById(@PathVariable Long id) {
        return refereeService.findById(id)
                .map(t -> ResponseEntity.ok().body(t))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/add")
    public ResponseEntity<Referee> create(@RequestParam Integer level) {
        return this.refereeService.create(level)
                .map(t -> ResponseEntity.ok().body(t))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //     create
//    update

    @PutMapping("/edit/{id}")
    public ResponseEntity<Referee> update(@PathVariable Long id, @RequestBody RefereeDto refereeDto) {
        return this.refereeService.edit(id, refereeDto)
                .map(t -> ResponseEntity.ok().body(t))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    //     delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Referee> delete(@PathVariable Long id) {
        this.refereeService.delete(id);
        if (this.refereeService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
