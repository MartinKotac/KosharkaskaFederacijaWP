package ukim.finki.mk.kosharkaskafederacija.model.dto;

import lombok.Data;
import ukim.finki.mk.kosharkaskafederacija.model.Team;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Data
public class PlayerDto {

    private String name;
    private Integer jerseyNumber;

    private String position;

    private Long teamId;

    private Double ppg;

    private Double apg;

    private Double rpg;

    private Double mpg;

    private Integer gamesPlayed;

    public PlayerDto(String name, Integer jerseyNumber, String position, Long teamId) {
        this.name = name;
        this.jerseyNumber = jerseyNumber;
        this.position = position;
        this.teamId = teamId;
        ppg=0.0;
        apg=0.0;
        rpg=0.0;
        mpg=0.0;
        gamesPlayed=0;
    }
}
