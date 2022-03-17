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
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CoachType coachType;

    @ManyToOne
    private Team team;

    public Coach(String name, CoachType coachType, Team team) {
        this.name = name;
        this.coachType = coachType;
        this.team = team;
    }
}
