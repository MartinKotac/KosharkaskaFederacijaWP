package ukim.finki.mk.kosharkaskafederacija.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Player {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer jerseyNumber;

    @Column(length = 2)
    private String position;

    @ManyToOne
    private Team team;

    private Double ppg;

    private Double apg;

    private Double rpg;

    private Double mpg;

    private Integer gamesPlayed;

    public Player(String name,Integer jerseyNumber, String position, Team idTeam) {
        this.name=name;
        this.jerseyNumber = jerseyNumber;
        this.position = position;
        this.team = idTeam;
        ppg=0.0;
        apg=0.0;
        rpg=0.0;
        mpg=0.0;
        gamesPlayed=0;
    }
}
