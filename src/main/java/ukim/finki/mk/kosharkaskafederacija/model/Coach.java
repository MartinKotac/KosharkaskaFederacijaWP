package ukim.finki.mk.kosharkaskafederacija.model;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Data
public class Coach {
    @Id
    @Column(name = "coach_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    //???
    @Column(name = "coach_type", length = 20)
    private String coachType;

    @ManyToOne
    @JoinColumn(name = "id_team")
    private Team idTeam;

}
