package ukim.finki.mk.kosharkaskafederacija.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.mk.kosharkaskafederacija.model.Player;
import ukim.finki.mk.kosharkaskafederacija.model.Team;
import ukim.finki.mk.kosharkaskafederacija.model.dto.PlayerDto;
import ukim.finki.mk.kosharkaskafederacija.model.dto.TeamDto;
import ukim.finki.mk.kosharkaskafederacija.service.TeamService;

import java.util.List;

@RestController
@RequestMapping("api/teams")
public class TeamRestController {
    private  final TeamService teamService;

    public TeamRestController(TeamService teamService) {
        this.teamService = teamService;
    }
    @GetMapping
    public List<Team> findAll() {
        return teamService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> findById(@PathVariable Long id) {
        return teamService.findById(id)
                .map(t -> ResponseEntity.ok().body(t))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    //     create
    @PostMapping("/add")
    public ResponseEntity<Team> create(@RequestBody TeamDto teamDto) {
        return this.teamService.create(teamDto)
                .map(t -> ResponseEntity.ok().body(t))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    update

    @PutMapping("/edit/{id}")
    public ResponseEntity<Team> update(@PathVariable Long id, @RequestBody TeamDto teamDto) {
        return this.teamService.edit(id, teamDto)
                .map(t -> ResponseEntity.ok().body(t))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    //     delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Team> delete(@PathVariable Long id) {
        this.teamService.delete(id);
        if (this.teamService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
    // increase points
    @PostMapping("/increase/{id}")
    public void increase(@PathVariable Long id, @RequestParam Integer points){
        this.teamService.increasePoints(id,points);
    }
}
