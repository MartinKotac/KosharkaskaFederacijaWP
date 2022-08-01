package ukim.finki.mk.kosharkaskafederacija.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String result;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime dateOfMaintenance;

    @ManyToMany
    private List<Referee> referees;

    @ManyToOne
    private Delegation delegation;

    @ManyToOne
    private Team homeTeam;

    @ManyToOne
    private Team awayTeam;

    @ManyToMany
    private List<Player> players;

    public Game(String statistics, LocalDateTime dateOfMaintenance, List<Referee> referees, Delegation delegation, Team HomeTeam, Team AwayTeam,List<Player> players) {
        this.result = statistics;
        this.dateOfMaintenance = dateOfMaintenance;
        this.referees = referees;
        this.delegation = delegation;
        this.homeTeam = HomeTeam;
        this.awayTeam = AwayTeam;
        this.players=players;
    }
}
