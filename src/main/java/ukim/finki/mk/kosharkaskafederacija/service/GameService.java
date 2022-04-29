package ukim.finki.mk.kosharkaskafederacija.service;

import ukim.finki.mk.kosharkaskafederacija.model.Game;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GameService {
    public Game create(String result, LocalDate dateОfMaintenance, List<Long> refereesId, Long delegation, Long homeTeam, Long awayTeam, List<Long> players);
    public Optional<Game> findById(Long id);
    public List<Game> findByDate(LocalDate date);
    public Optional<Game> delete(Long id);
    public Game edit(Long id,String result, LocalDate dateОfMaintenance, List<Long> refereesId, Long delegation, Long homeTeam, Long awayTeam, List<Long> players );
    public List<Game> findAll();
}
