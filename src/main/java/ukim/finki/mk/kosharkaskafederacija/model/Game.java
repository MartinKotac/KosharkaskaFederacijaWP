package ukim.finki.mk.kosharkaskafederacija.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id", nullable = false)
    private Integer id;

    private String result;

    private LocalDate dateОfMaintenance;

    @ManyToMany
    private List<Referee> referees;

    @ManyToOne
    private Delegation delegation;

    @ManyToOne
    private Team idHomeTeam;

    @ManyToOne
    private Team idAwayTeam;

    public Game(String statistics, LocalDate dateОfMaintenance, List<Referee> referees, Delegation delegation, Team idHomeTeam, Team idAwayTeam) {
        this.result = statistics;
        this.dateОfMaintenance = dateОfMaintenance;
        this.referees = referees;
        this.delegation = delegation;
        this.idHomeTeam = idHomeTeam;
        this.idAwayTeam = idAwayTeam;
    }
}
