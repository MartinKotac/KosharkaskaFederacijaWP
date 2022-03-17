package ukim.finki.mk.kosharkaskafederacija.model;


import lombok.*;
import ukim.finki.mk.kosharkaskafederacija.enumerations.CoachType;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Coach {
    @Id
    @Column(name = "coach_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CoachType coachType;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
