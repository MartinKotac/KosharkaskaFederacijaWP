package ukim.finki.mk.kosharkaskafederacija.service;

import ukim.finki.mk.kosharkaskafederacija.model.Delegation;
import ukim.finki.mk.kosharkaskafederacija.model.Game;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface GameService {
    public Game create(String result, LocalDate dateОfMaintenance, List<Integer> refereesId, Long delegation, String homeTeam, String awayTeam);
    public Game findById(Long id);
    public List<Game> findByDate(LocalDate date);
    public Game delete(Long id);
    public Game edit(Long id,String result, LocalDate dateОfMaintenance, List<Integer> refereesId, Long delegation, String homeTeam, String awayTeam);
}
