package ukim.finki.mk.kosharkaskafederacija.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id", nullable = false)
    private Integer id;

    //Ova treba da bide poslozeno
    private String statistics;

    private LocalDate dateОfMaintenance;

    @ManyToMany
    private Referee referee;

    @ManyToOne
    //@JoinColumn(name = "embg")
    private Delegation delegation;

    @ManyToOne
    //@JoinColumn(name = "id_klub_domakin")
    private Team idHomeTeam;

    @ManyToOne
    //@JoinColumn(name = "id_klub_gostin")
    private Team idAwayTeam;

    public Game(String statistics, LocalDate dateОfMaintenance, Referee referee, Delegation delegation, Team idHomeTeam, Team idAwayTeam) {
        this.statistics = statistics;
        this.dateОfMaintenance = dateОfMaintenance;
        this.referee = referee;
        this.delegation = delegation;
        this.idHomeTeam = idHomeTeam;
        this.idAwayTeam = idAwayTeam;
    }
}
