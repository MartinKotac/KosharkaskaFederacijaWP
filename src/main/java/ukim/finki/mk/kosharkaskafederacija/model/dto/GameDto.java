package ukim.finki.mk.kosharkaskafederacija.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class GameDto {
    private String result;
    private LocalDate dateОfMaintenance;
    private List<Long> refereesId;
    private Long delegation;
    private Long homeTeam;
    private Long awayTeam;
    private List<Long> players;

    public GameDto(String result, LocalDate dateОfMaintenance, List<Long> refereesId, Long delegation, Long homeTeam, Long awayTeam, List<Long> players) {
        this.result = result;
        this.dateОfMaintenance = dateОfMaintenance;
        this.refereesId = refereesId;
        this.delegation = delegation;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.players = players;
    }
}
