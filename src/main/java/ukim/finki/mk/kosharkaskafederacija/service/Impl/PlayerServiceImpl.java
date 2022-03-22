package ukim.finki.mk.kosharkaskafederacija.service.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.kosharkaskafederacija.exceptions.PlayerDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.exceptions.TeamDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.model.Player;
import ukim.finki.mk.kosharkaskafederacija.model.Team;
import ukim.finki.mk.kosharkaskafederacija.repository.PlayerRepository;
import ukim.finki.mk.kosharkaskafederacija.repository.TeamRepository;
import ukim.finki.mk.kosharkaskafederacija.service.PlayerService;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public Player create(String name, Integer jerseyNumber, String position, Long teamId) {
        if(teamRepository.findById(teamId).isPresent())
        {
            Team team=teamRepository.findById(teamId).get();
            Player player=new Player(name,jerseyNumber,position,team);
            playerRepository.save(player);
            team.getPlayers().add(player);
            return player;
        }
        else
            throw new TeamDoesNotExistException(teamId);
    }

    @Override
    public Player delete(Long id) {
        return null;
    }

    @Override
    public Player edit(Long id, String name, Integer jerseyNumber, String position, String teamName) {
        return null;
    }

    @Override
    public Player findById(Long id) {
        return playerRepository.findById(id).orElseThrow(()->new PlayerDoesNotExistException(id));
    }

    @Override
    public List<Player> listAll() {
        return null;
    }

    @Override
    public void setPpg() {
    }

    @Override
    public void setAng() {
    }

    @Override
    public void setRpg() {
    }

    @Override
    public void setMpg() {
    }

    @Override
    public void addGame() {
    }
}
