package ukim.finki.mk.kosharkaskafederacija.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Data
public class Player {
    @Id
    @Column(name = "player_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer jerseyNumber;

    @Column(length = 2)
    private String position;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Team idTeam;

    //to do: broj poeni


    public Player(Integer jerseyNumber, String position, Team idTeam) {
        this.jerseyNumber = jerseyNumber;
        this.position = position;
        this.idTeam = idTeam;
    }


}
