package ukim.finki.mk.kosharkaskafederacija.service.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.kosharkaskafederacija.exceptions.DelegationDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.exceptions.GameDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.exceptions.RefereeDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.exceptions.TeamDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.model.Delegation;
import ukim.finki.mk.kosharkaskafederacija.model.Game;
import ukim.finki.mk.kosharkaskafederacija.model.Referee;
import ukim.finki.mk.kosharkaskafederacija.model.Team;
import ukim.finki.mk.kosharkaskafederacija.repository.DelegationRepository;
import ukim.finki.mk.kosharkaskafederacija.repository.GameRepository;
import ukim.finki.mk.kosharkaskafederacija.repository.RefereeRepository;
import ukim.finki.mk.kosharkaskafederacija.repository.TeamRepository;
import ukim.finki.mk.kosharkaskafederacija.service.GameService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final RefereeRepository refereeRepository;
    private final DelegationRepository delegationRepository;
    private final TeamRepository teamRepository;

    public GameServiceImpl(GameRepository gameRepository, RefereeRepository refereeRepository, DelegationRepository delegationRepository, TeamRepository teamRepository) {
        this.gameRepository = gameRepository;
        this.refereeRepository = refereeRepository;
        this.delegationRepository = delegationRepository;
        this.teamRepository = teamRepository;
    }


    @Override
    public Game create(String result, LocalDate dateОfMaintenance, List<Integer> refereesId, Long delegationId, String homeTeam, String awayTeam) {
        List<Referee> referees = refereeRepository.findAllById(refereesId);
        Team Team1=teamRepository.findById(homeTeam).orElseThrow(()->new TeamDoesNotExistException(homeTeam));
        Team Team2 = teamRepository.findById(awayTeam).orElseThrow(()->new TeamDoesNotExistException((awayTeam)));
        Delegation delegation=delegationRepository.findById(delegationId.intValue()).orElseThrow(()->new DelegationDoesNotExistException(delegationId));
        if(referees.size()>0)
            return gameRepository.save(new Game(result,dateОfMaintenance,referees,delegation,Team1,Team2));
        else
            throw new RefereeDoesNotExistException(refereesId.get(0).longValue());
    }

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id.intValue()).orElseThrow(()->new GameDoesNotExistException(id));
    }

    @Override
    public List<Game> findByDate(LocalDate date) {
        return gameRepository.findAllByDateОfMaintenance(date);
    }

    @Override
    public Game delete(Long id) {
        Game game=gameRepository.findById(id.intValue()).orElseThrow(()->new GameDoesNotExistException(id));
        gameRepository.deleteById(id.intValue());
        return game;
    }

    @Override
    public Game edit(Long id, String result, LocalDate dateОfMaintenance, List<Integer> refereesId, Long delegationId, String homeTeam, String awayTeam) {
        Game game=gameRepository.findById(id.intValue()).orElseThrow(()->new GameDoesNotExistException(id));
        List<Referee> referees = refereeRepository.findAllById(refereesId);
        Team Team1=teamRepository.findById(homeTeam).orElseThrow(()->new TeamDoesNotExistException(homeTeam));
        Team Team2 = teamRepository.findById(awayTeam).orElseThrow(()->new TeamDoesNotExistException((awayTeam)));
        Delegation delegation=delegationRepository.findById(delegationId.intValue()).orElseThrow(()->new DelegationDoesNotExistException(delegationId));
        game.setResult(result);
        game.setDateОfMaintenance(dateОfMaintenance);
        game.setReferees(referees);
        game.setDelegation(delegation);
        game.setIdHomeTeam(Team1);
        game.setIdHomeTeam(Team2);
        return gameRepository.save(game);
    }
}
