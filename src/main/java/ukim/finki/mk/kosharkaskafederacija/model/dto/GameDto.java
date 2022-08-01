package ukim.finki.mk.kosharkaskafederacija.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class GameDto {
    private String result;
    private LocalDateTime dateOfMaintenance;
    private List<Long> refereesId;
    private Long delegation;
    private Long homeTeam;
    private Long awayTeam;
    private List<Long> players;

    public GameDto(String result, LocalDateTime dateOfMaintenance, List<Long> refereesId, Long delegation, Long homeTeam, Long awayTeam, List<Long> players) {
        this.result = result;
        this.dateOfMaintenance = dateOfMaintenance;
        this.refereesId = refereesId;
        this.delegation = delegation;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.players = players;
    }
}
