package ukim.finki.mk.kosharkaskafederacija.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.mk.kosharkaskafederacija.model.Delegation;
import ukim.finki.mk.kosharkaskafederacija.model.Referee;
import ukim.finki.mk.kosharkaskafederacija.model.dto.DelegationDto;
import ukim.finki.mk.kosharkaskafederacija.model.dto.RefereeDto;
import ukim.finki.mk.kosharkaskafederacija.service.DelegationService;

import java.util.List;

@RestController
@RequestMapping("/api/delegation")
public class DelegationRestController {
    private final DelegationService delegationService;

    public DelegationRestController(DelegationService delegationService) {
        this.delegationService = delegationService;
    }
    @GetMapping
    public List<Delegation> findAll() {
        return delegationService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delegation> findById(@PathVariable Long id) {
        return delegationService.findById(id)
                .map(t -> ResponseEntity.ok().body(t))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    //     create
    @PostMapping("/add")
    public ResponseEntity<Delegation> create(@RequestBody DelegationDto delegationDto) {
        return this.delegationService.create(delegationDto)
                .map(t -> ResponseEntity.ok().body(t))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    update

    @PutMapping("/edit/{id}")
    public ResponseEntity<Delegation> update(@PathVariable Long id, @RequestBody DelegationDto delegationDto) {
        return this.delegationService.edit(id, delegationDto)
                .map(t -> ResponseEntity.ok().body(t))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    //     delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Delegation> delete(@PathVariable Long id) {
        this.delegationService.delete(id);
        if (this.delegationService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
