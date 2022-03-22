package ukim.finki.mk.kosharkaskafederacija.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id", nullable = false)
    private Long id;

    private String result;

    private LocalDate dateОfMaintenance;

    @ManyToMany
    private List<Referee> referees;

    @ManyToOne
    private Delegation delegation;

    @ManyToOne
    private Team HomeTeam;

    @ManyToOne
    private Team AwayTeam;

    @ManyToMany
    private List<Player> players;

    public Game(String statistics, LocalDate dateОfMaintenance, List<Referee> referees, Delegation delegation, Team HomeTeam, Team AwayTeam,List<Player> players) {
        this.result = statistics;
        this.dateОfMaintenance = dateОfMaintenance;
        this.referees = referees;
        this.delegation = delegation;
        this.HomeTeam = HomeTeam;
        this.AwayTeam = AwayTeam;
        this.players=players;
    }
}
