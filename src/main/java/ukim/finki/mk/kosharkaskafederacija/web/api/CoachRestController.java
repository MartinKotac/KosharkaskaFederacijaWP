package ukim.finki.mk.kosharkaskafederacija.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.mk.kosharkaskafederacija.enumerations.CoachType;
import ukim.finki.mk.kosharkaskafederacija.model.Coach;
import ukim.finki.mk.kosharkaskafederacija.model.dto.CoachDto;
import ukim.finki.mk.kosharkaskafederacija.service.CoachService;

import java.util.List;

@RestController
@RequestMapping("/api/coaches")
public class CoachRestController {
    private final CoachService coachService;

    public CoachRestController(CoachService coachService) {
        this.coachService = coachService;
    }
    // read

    @GetMapping
    public List<Coach> findAll(){
        return coachService.listAll();
    }
    @GetMapping("/types")
    public CoachType[] findAllCoachTypes(){
        return CoachType.values();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coach> findById(@PathVariable Long id){
        return coachService.findById(id)
                .map(book->ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.notFound().build());
    }


    // create
    @PostMapping("/add")
    public ResponseEntity<Coach> create(@RequestBody CoachDto coachDto){
        return this.coachService.create(coachDto)
                .map(book->ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    // update

    @PutMapping("/edit/{id}")
    public ResponseEntity<Coach> update(@PathVariable Long id,@RequestBody CoachDto coachDto) {
        return this.coachService.edit(id,coachDto)
                .map(book->ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());

    }

    // delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Coach> delete(@PathVariable Long id){
        this.coachService.delete(id);
        if(this.coachService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }


}
