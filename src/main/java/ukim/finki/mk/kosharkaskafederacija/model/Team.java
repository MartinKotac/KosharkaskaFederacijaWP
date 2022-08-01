package ukim.finki.mk.kosharkaskafederacija.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Team {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    private String sponsor;

    private String homeField;

    private Integer points;

//    @OneToMany(fetch = FetchType.EAGER,mappedBy = "team")
    @OneToMany(mappedBy = "team")
    @JsonBackReference
    List<Player> players;

//    @OneToMany(fetch = FetchType.EAGER,mappedBy = "team")
    @OneToMany(mappedBy = "team")
    @JsonBackReference
    List<Coach> coaches;


    public Team(String name, String address, String sponsor, String homeField) {
        this.name = name;
        this.address = address;
        this.sponsor = sponsor;
        this.homeField = homeField;
        points=0;
        players=new ArrayList<>();
        coaches=new ArrayList<>();
    }
}
