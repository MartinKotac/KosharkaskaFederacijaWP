package ukim.finki.mk.kosharkaskafederacija.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.mk.kosharkaskafederacija.model.Player;
import ukim.finki.mk.kosharkaskafederacija.model.dto.PlayerDto;
import ukim.finki.mk.kosharkaskafederacija.service.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerRestController {
    private final PlayerService playerService;

    public PlayerRestController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // read

    @GetMapping
    public List<Player> findAll() {
        return playerService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> findById(@PathVariable Long id) {
        return playerService.findById(id)
                .map(t -> ResponseEntity.ok().body(t))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    //     create
    @PostMapping("/add")
    public ResponseEntity<Player> create(@RequestBody PlayerDto playerDto) {
        return this.playerService.create(playerDto)
                .map(t -> ResponseEntity.ok().body(t))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    update

    @PutMapping("/edit/{id}")
    public ResponseEntity<Player> update(@PathVariable Long id, @RequestBody PlayerDto playerDto) {
        return this.playerService.edit(id, playerDto)
                .map(t -> ResponseEntity.ok().body(t))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    //     delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Player> delete(@PathVariable Long id) {
        this.playerService.delete(id);
        if (this.playerService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}