package ukim.finki.mk.kosharkaskafederacija.service.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.kosharkaskafederacija.exceptions.TeamDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.model.Team;
import ukim.finki.mk.kosharkaskafederacija.repository.TeamRepository;
import ukim.finki.mk.kosharkaskafederacija.service.TeamService;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team create(String name, String address, String sponsor, String homeField) {
        return teamRepository.save(new Team(name,address,sponsor,homeField));
    }

    @Override
    public Team findById(Long id) {
        return teamRepository.findById(id).orElseThrow(()-> new TeamDoesNotExistException(id));
    }

    @Override
    public Team delete(Long id) {
        Team team=teamRepository.findById(id).orElseThrow(()-> new TeamDoesNotExistException(id));;
        teamRepository.delete(team);
        return team;
    }

    @Override
    public Team edit(Long id,String name, String address, String sponsor, String homeField) {
        Team team=teamRepository.findById(id).orElseThrow(()-> new TeamDoesNotExistException(id));;
        team.setName(name);
        team.setAddress(address);
        team.setSponsor(sponsor);
        team.setHomeField(homeField);
        return teamRepository.save(team);
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
