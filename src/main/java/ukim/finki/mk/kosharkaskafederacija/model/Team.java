package ukim.finki.mk.kosharkaskafederacija.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "team_id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    //dali moze da bide lista?
    private String sponsor;

    private String homeField;

    private Integer points;

    //to do: zaso tuka ne gi cuvame igracite i trenerot?

    public Team(String name, String address, String sponsor, String homeField) {
        this.name = name;
        this.address = address;
        this.sponsor = sponsor;
        this.homeField = homeField;
        points=0;
    }
}
