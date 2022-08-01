package ukim.finki.mk.kosharkaskafederacija.service.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.kosharkaskafederacija.exceptions.DelegationDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.exceptions.GameDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.exceptions.TeamDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.model.*;
import ukim.finki.mk.kosharkaskafederacija.repository.*;
import ukim.finki.mk.kosharkaskafederacija.service.GameService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public Game create(String result, LocalDateTime dateОfMaintenance, List<Long> refereesId, Long delegationId, Long homeTeam, Long awayTeam, List<Long> players) {
        List<Referee> referees = refereeRepository.findAllById(refereesId);
        Team Team1=teamRepository.findById(homeTeam).orElseThrow(()->new TeamDoesNotExistException(homeTeam));
        Team Team2 = teamRepository.findById(awayTeam).orElseThrow(()->new TeamDoesNotExistException((awayTeam)));
        Delegation delegation=delegationRepository.findById(delegationId).orElseThrow(()->new DelegationDoesNotExistException(delegationId));
        List<Player> playerList=playerRepository.findAllById(players);
        playerList.forEach(a->{
            a.setGamesPlayed(a.getGamesPlayed()+1);
            playerRepository.save(a);
        });
        int t1= Integer.parseInt(result.split("-")[0]);
        int t2= Integer.parseInt(result.split("-")[1]);
        if(t1>t2){
            Team1.setPoints(Team1.getPoints()+2);
        }else if(t1<t2){
            Team2.setPoints(Team1.getPoints()+2);
        }

        return gameRepository.save(new Game(result,dateОfMaintenance,referees,delegation,Team1,Team2,playerList));
    }

    @Override
    public Optional<Game> findById(Long id) {
        return gameRepository.findById(id);
    }

    @Override
    public List<Game> findByDate(LocalDateTime date) {
        return gameRepository.findAllByDateOfMaintenance(date);
    }

    @Override
    public Optional<Game> delete(Long id) {
        Optional<Game> game=gameRepository.findById(id);
        gameRepository.deleteById(id);
        return game;
    }

    @Override
    public Game edit(Long id, String result, LocalDateTime dateОfMaintenance, List<Long> refereesId, Long delegationId, Long homeTeam, Long awayTeam,List<Long> players) {
        Game game=gameRepository.findById(id).orElseThrow(()->new GameDoesNotExistException(id));
        List<Referee> referees = refereeRepository.findAllById(refereesId);
        Team Team1=teamRepository.findById(homeTeam).orElseThrow(()->new TeamDoesNotExistException(homeTeam));
        Team Team2 = teamRepository.findById(awayTeam).orElseThrow(()->new TeamDoesNotExistException((awayTeam)));
        List<Player> playerList=playerRepository.findAllById(players);
        Delegation delegation=delegationRepository.findById(delegationId).orElseThrow(()->new DelegationDoesNotExistException(delegationId));
        game.setResult(result);
        game.setDateOfMaintenance(dateОfMaintenance);
        game.setReferees(referees);
        game.setDelegation(delegation);
        game.setHomeTeam(Team1);
        game.setAwayTeam(Team2);
        game.setPlayers(playerList);
        return gameRepository.save(game);
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }
}
