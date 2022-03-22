package ukim.finki.mk.kosharkaskafederacija.service.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.kosharkaskafederacija.exceptions.DelegationDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.exceptions.GameDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.exceptions.RefereeDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.exceptions.TeamDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.model.*;
import ukim.finki.mk.kosharkaskafederacija.repository.*;
import ukim.finki.mk.kosharkaskafederacija.service.GameService;

import java.time.LocalDate;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final RefereeRepository refereeRepository;
    private final DelegationRepository delegationRepository;
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    public GameServiceImpl(GameRepository gameRepository, RefereeRepository refereeRepository, DelegationRepository delegationRepository, TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.gameRepository = gameRepository;
        this.refereeRepository = refereeRepository;
        this.delegationRepository = delegationRepository;
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }


    @Override
    public Game create(String result, LocalDate dateОfMaintenance, List<Long> refereesId, Long delegationId, Long homeTeam, Long awayTeam,List<Long> players) {
        List<Referee> referees = refereeRepository.findAllById(refereesId);
        Team Team1=teamRepository.findById(homeTeam).orElseThrow(()->new TeamDoesNotExistException(homeTeam));
        Team Team2 = teamRepository.findById(awayTeam).orElseThrow(()->new TeamDoesNotExistException((awayTeam)));
        Delegation delegation=delegationRepository.findById(delegationId).orElseThrow(()->new DelegationDoesNotExistException(delegationId));
        List<Player> playerList=playerRepository.findAllById(players);
        return gameRepository.save(new Game(result,dateОfMaintenance,referees,delegation,Team1,Team2,playerList));
    }

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id).orElseThrow(()->new GameDoesNotExistException(id));
    }

    @Override
    public List<Game> findByDate(LocalDate date) {
        return gameRepository.findAllByDateОfMaintenance(date);
    }

    @Override
    public Game delete(Long id) {
        Game game=gameRepository.findById(id).orElseThrow(()->new GameDoesNotExistException(id));
        gameRepository.deleteById(id);
        return game;
    }

    @Override
    public Game edit(Long id, String result, LocalDate dateОfMaintenance, List<Long> refereesId, Long delegationId, Long homeTeam, Long awayTeam,List<Long> players) {
        Game game=gameRepository.findById(id).orElseThrow(()->new GameDoesNotExistException(id));
        List<Referee> referees = refereeRepository.findAllById(refereesId);
        Team Team1=teamRepository.findById(homeTeam).orElseThrow(()->new TeamDoesNotExistException(homeTeam));
        Team Team2 = teamRepository.findById(awayTeam).orElseThrow(()->new TeamDoesNotExistException((awayTeam)));
        List<Player> playerList=playerRepository.findAllById(players);
        Delegation delegation=delegationRepository.findById(delegationId).orElseThrow(()->new DelegationDoesNotExistException(delegationId));
        game.setResult(result);
        game.setDateОfMaintenance(dateОfMaintenance);
        game.setReferees(referees);
        game.setDelegation(delegation);
        game.setHomeTeam(Team1);
        game.setAwayTeam(Team2);
        game.setPlayers(playerList);
        return gameRepository.save(game);
    }
}
