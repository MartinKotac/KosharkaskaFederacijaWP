package ukim.finki.mk.kosharkaskafederacija.service.Impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ukim.finki.mk.kosharkaskafederacija.enumerations.CoachType;
import ukim.finki.mk.kosharkaskafederacija.exceptions.CoachDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.exceptions.TeamCoachesLimitException;
import ukim.finki.mk.kosharkaskafederacija.exceptions.TeamDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.model.Coach;
import ukim.finki.mk.kosharkaskafederacija.model.Team;
import ukim.finki.mk.kosharkaskafederacija.repository.CoachRepository;
import ukim.finki.mk.kosharkaskafederacija.repository.TeamRepository;
import ukim.finki.mk.kosharkaskafederacija.service.CoachService;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {

    private final TeamRepository teamRepository;
    private final CoachRepository coachRepository;

    public CoachServiceImpl(TeamRepository teamRepository, CoachRepository coachRepository) {
        this.teamRepository = teamRepository;
        this.coachRepository = coachRepository;
    }

    @Override
    public Coach create(String name, CoachType coachType, Long team) {
        if(teamRepository.findById(team).isPresent())
        {
            Team tmp=teamRepository.findById(team).get();
            if((coachType.equals(CoachType.HEAD) && tmp.getCoaches().stream().anyMatch(p -> p.getCoachType().equals(CoachType.HEAD)))
                || (coachType.equals(CoachType.ASSISTANT) && tmp.getCoaches().stream().filter(p->p.getCoachType().equals(CoachType.ASSISTANT)).count()>2))
            {
                throw new TeamCoachesLimitException(team);
            }
            else
            {
                Coach coach=coachRepository.save(new Coach(name,coachType,tmp));
                tmp.getCoaches().add(coach);
                return coach;
            }
        }
        else
            throw new TeamDoesNotExistException(team);
    }

    @Override
    public Coach findById(Long id) {
        return coachRepository.findById(id).orElseThrow(()->new CoachDoesNotExistException(id));
    }

    @Override
    public Coach delete(Long id) {
        Coach tmp=coachRepository.findById(id).orElseThrow(()->new CoachDoesNotExistException(id));
        coachRepository.deleteById(id);
        return tmp;
    }



    @Override
    public Coach edit(Long id,String name, CoachType coachType, Long team) {
        Coach coach=coachRepository.findById(id).orElseThrow(()->new CoachDoesNotExistException(id));
        coach.setName(name);
        if(teamRepository.findById(team).isPresent())
        {
            Team tmp=teamRepository.findById(team).get();
            coach.setTeam(tmp);
            if((coachType.equals(CoachType.HEAD) && tmp.getCoaches().stream().anyMatch(p -> p.getCoachType().equals(CoachType.HEAD)))
                    || (coachType.equals(CoachType.ASSISTANT) && tmp.getCoaches().stream().filter(p->p.getCoachType().equals(CoachType.ASSISTANT)).count()>2))
            {
                throw new TeamCoachesLimitException(team);
            }
            else
            {
               coach.setCoachType(coachType);
            }
            coachRepository.save(coach);
        }
        else
            throw new TeamDoesNotExistException(team);
        return coach;
    }

    @Override
    public List<Coach> listAll() {
        return coachRepository.findAll();
    }

    @Override
    public boolean transfer(Long coachId, Long team1, Long team2) {
        Team teamFrom=teamRepository.findById(team1).orElseThrow(()->new TeamDoesNotExistException(team1));
        Team teamTo=teamRepository.findById(team2).orElseThrow(()->new TeamDoesNotExistException(team2));
        Coach coach=coachRepository.findById(coachId).orElseThrow(()->new CoachDoesNotExistException(coachId));
        if((coach.getCoachType().equals(CoachType.HEAD) && teamTo.getCoaches().stream().anyMatch(p -> p.getCoachType().equals(CoachType.HEAD)))
                || (coach.getCoachType().equals(CoachType.ASSISTANT) && teamTo.getCoaches().stream().filter(p->p.getCoachType().equals(CoachType.ASSISTANT)).count()>2))
        {
            throw new TeamCoachesLimitException(team1);
        }
        else
        {
            teamFrom.getCoaches().remove(coach);
            teamTo.getCoaches().add(coach);
            return true;
        }

    }
}
