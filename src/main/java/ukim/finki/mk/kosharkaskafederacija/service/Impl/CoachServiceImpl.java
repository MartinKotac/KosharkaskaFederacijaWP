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
    public Coach create(String name, CoachType coachType, String team) {
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
        return coachRepository.findById(id.intValue()).orElseThrow(()->new CoachDoesNotExistException(id));
    }

    @Override
    public Coach delete(Long id) {
        Coach tmp=coachRepository.findById(id.intValue()).orElseThrow(()->new CoachDoesNotExistException(id));
        coachRepository.deleteById(id.intValue());
        return tmp;
    }

    @Override
    public Coach deleteFromTeam(Long id,String teamName) {
        return null;
    }

    @Override
    public Coach edit(Long id,String name, CoachType coachType, String team) {
        Coach coach=coachRepository.findById(id.intValue()).orElseThrow(()->new CoachDoesNotExistException(id));
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
}
