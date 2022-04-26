package ukim.finki.mk.kosharkaskafederacija.model.dto;

import lombok.Data;
import ukim.finki.mk.kosharkaskafederacija.enumerations.CoachType;
import ukim.finki.mk.kosharkaskafederacija.model.Team;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
@Data
public class CoachDto {


    private String name;

    private CoachType coachType;

    private Long teamId;

    public CoachDto(String name, CoachType coachType, Long teamId) {
        this.name = name;
        this.coachType = coachType;
        this.teamId = teamId;
    }
}
