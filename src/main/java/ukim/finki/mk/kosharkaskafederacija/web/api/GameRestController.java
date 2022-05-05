package ukim.finki.mk.kosharkaskafederacija.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.mk.kosharkaskafederacija.model.Game;
import ukim.finki.mk.kosharkaskafederacija.model.Team;
import ukim.finki.mk.kosharkaskafederacija.model.dto.GameDto;
import ukim.finki.mk.kosharkaskafederacija.model.dto.TeamDto;
import ukim.finki.mk.kosharkaskafederacija.service.GameService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameRestController {
    private final GameService gameService;

    public GameRestController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> findAll() {
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> findById(@PathVariable Long id) {
        return gameService.findById(id)
                .map(t -> ResponseEntity.ok().body(t))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    //     create
    @PostMapping("/add")
    public ResponseEntity<Game> create(@RequestBody GameDto gameDto) {
        Game game=this.gameService.create(gameDto.getResult(), gameDto.getDateOfMaintenance(),gameDto.getRefereesId(),gameDto.getDelegation(),gameDto.getHomeTeam(),gameDto.getAwayTeam(),gameDto.getPlayers());
        return ResponseEntity.ok().body(game);
    }

//    update

    @PutMapping("/edit/{id}")
    public ResponseEntity<Game> update(@PathVariable Long id, @RequestBody GameDto gameDto) {
        Game game=this.gameService.edit(id,gameDto.getResult(),gameDto.getDateOfMaintenance(),gameDto.getRefereesId(),gameDto.getDelegation(),gameDto.getHomeTeam(),gameDto.getAwayTeam(),gameDto.getPlayers());
        return ResponseEntity.ok().body(game);

    }

    //     delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Game> delete(@PathVariable Long id) {
        return this.gameService.delete(id)
                .map(t -> ResponseEntity.ok().body(t))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
