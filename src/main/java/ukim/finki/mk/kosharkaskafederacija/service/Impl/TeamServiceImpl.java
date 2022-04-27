package ukim.finki.mk.kosharkaskafederacija.service.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.kosharkaskafederacija.exceptions.TeamDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.model.Team;
import ukim.finki.mk.kosharkaskafederacija.model.dto.TeamDto;
import ukim.finki.mk.kosharkaskafederacija.repository.TeamRepository;
import ukim.finki.mk.kosharkaskafederacija.service.TeamService;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService{

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Optional<Team> create(TeamDto teamDto) {
        Team team =new Team(teamDto.getName(), teamDto.getAddress(), teamDto.getSponsor(), teamDto.getHomeField());
        return Optional.of(teamRepository.save(team));
    }

    @Override
    public Optional<Team>  findById(Long id) {
        return Optional.of(teamRepository.findById(id).orElseThrow(()-> new TeamDoesNotExistException(id)));
    }

    @Override
    public Optional<Team>  delete(Long id) {
        Team team=teamRepository.findById(id).orElseThrow(()-> new TeamDoesNotExistException(id));;
        teamRepository.delete(team);
        return Optional.of(team);
    }

    @Override
    public Optional<Team> edit(Long id, TeamDto teamDto) {
        Team team=teamRepository.findById(id).orElseThrow(()-> new TeamDoesNotExistException(id));;
        team.setName(teamDto.getName());
        team.setAddress(team.getAddress());
        team.setSponsor(teamDto.getSponsor());
        team.setHomeField(teamDto.getHomeField());
        return Optional.of(teamRepository.save(team));
    }

    @Override
    public void increasePoints(Long id,Integer points) {
        Team team=teamRepository.findById(id).orElseThrow(()-> new TeamDoesNotExistException(id));
        team.setPoints(team.getPoints()+points);
    }

    @Override
    public List<Team> listAll() {
        return teamRepository.findAll();
    }
}
