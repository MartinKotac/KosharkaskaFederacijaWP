package ukim.finki.mk.kosharkaskafederacija.service.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.kosharkaskafederacija.exceptions.PlayerDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.exceptions.TeamDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.model.Player;
import ukim.finki.mk.kosharkaskafederacija.model.Team;
import ukim.finki.mk.kosharkaskafederacija.model.dto.PlayerDto;
import ukim.finki.mk.kosharkaskafederacija.repository.PlayerRepository;
import ukim.finki.mk.kosharkaskafederacija.repository.TeamRepository;
import ukim.finki.mk.kosharkaskafederacija.service.PlayerService;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }


    //teamId staticno se dava poso kreiranjeto na objekt od player e samo preku team
    @Override
    public Optional<Player> create(PlayerDto playerDto) {
        if(teamRepository.findById(playerDto.getTeamId()).isPresent())
        {
            Team team=teamRepository.findById(playerDto.getTeamId()).get();
            Player player=new Player(playerDto.getName(),playerDto.getJerseyNumber(),playerDto.getPosition(),team);
            playerRepository.save(player);
            team.getPlayers().add(player);
            return Optional.of(player);
        }
        else
            throw new TeamDoesNotExistException(playerDto.getTeamId());
    }

    @Override
    public Optional<Player> delete(Long id) {
        Player p=playerRepository.findById(id).orElseThrow(()-> new PlayerDoesNotExistException(id));
        playerRepository.delete(p);
        return Optional.of(p);
    }

    //teamId staticno se stava poso treba da go najdeme timo da izbrisame stario i da dodademe novio player linija 55 i 56
    @Override
    public Optional<Player> edit(Long id,PlayerDto playerDto) {
        Player player=playerRepository.findById(id).orElseThrow(()->new PlayerDoesNotExistException(id));
        player.setJerseyNumber(playerDto.getJerseyNumber());
        player.setPosition(playerDto.getPosition());
        player.setName(playerDto.getName());
        Team team=teamRepository.findById(playerDto.getTeamId()).orElseThrow(()->new TeamDoesNotExistException(id));
        team.getPlayers().remove(player);
        team.getPlayers().add(player);
        playerRepository.save(player);
        return Optional.of(player);
    }

    @Override
    public boolean transfer(Long from, Long to, Long playerId) {
        Team teamFrom=teamRepository.findById(from).orElseThrow(()->new TeamDoesNotExistException(from));
        Team teamTo=teamRepository.findById(to).orElseThrow(()->new TeamDoesNotExistException(to));
        Player player=playerRepository.findById(playerId).orElseThrow(()->new PlayerDoesNotExistException(playerId));
        player.setTeam(teamTo);
        teamFrom.getPlayers().remove(player);
        teamTo.getPlayers().add(player);
        return true;
    }

    @Override
    public Optional<Player> findById(Long id) {
        return Optional.of(playerRepository.findById(id).orElseThrow(()->new PlayerDoesNotExistException(id)));
    }

    @Override
    public List<Player> listAll() {
        return playerRepository.findAll();
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
