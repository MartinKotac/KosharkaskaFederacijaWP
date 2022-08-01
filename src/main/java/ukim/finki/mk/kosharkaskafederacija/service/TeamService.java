package ukim.finki.mk.kosharkaskafederacija.service;

import ukim.finki.mk.kosharkaskafederacija.model.Team;
import ukim.finki.mk.kosharkaskafederacija.model.dto.TeamDto;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    public Optional<Team> create(TeamDto teamDto);
    public Optional<Team> findById(Long id);
    public Optional<Team> delete(Long id);
    public Optional<Team> edit(Long id, TeamDto teamDto);
    public void increasePoints(Long id,Integer points);
    public List<Team> listAll();
}
