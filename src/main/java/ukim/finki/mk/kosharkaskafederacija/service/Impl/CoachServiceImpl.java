package ukim.finki.mk.kosharkaskafederacija.service.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.kosharkaskafederacija.enumerations.CoachType;
import ukim.finki.mk.kosharkaskafederacija.exceptions.CoachDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.exceptions.TeamCoachesLimitException;
import ukim.finki.mk.kosharkaskafederacija.exceptions.TeamDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.model.Coach;
import ukim.finki.mk.kosharkaskafederacija.model.Team;
import ukim.finki.mk.kosharkaskafederacija.model.dto.CoachDto;
import ukim.finki.mk.kosharkaskafederacija.repository.CoachRepository;
import ukim.finki.mk.kosharkaskafederacija.repository.TeamRepository;
import ukim.finki.mk.kosharkaskafederacija.service.CoachService;

import java.util.List;
import java.util.Optional;

@Service
public class CoachServiceImpl implements CoachService {

    private final TeamRepository teamRepository;
    private final CoachRepository coachRepository;

    public CoachServiceImpl(TeamRepository teamRepository, CoachRepository coachRepository) {
        this.teamRepository = teamRepository;
        this.coachRepository = coachRepository;
    }

    //team e id so staticno se dava poso kreiranjeto na objekt od coach e samo preku team
    @Override
    public Optional<Coach> create(CoachDto coachDto) {
        if (teamRepository.findById(coachDto.getTeamId()).isPresent()) {
            Team tmp = teamRepository.findById(coachDto.getTeamId()).get();
            if ((coachDto.getCoachType().equals(CoachType.HEAD) && tmp.getCoaches().stream().anyMatch(p -> p.getCoachType().equals(CoachType.HEAD)))
                    || (coachDto.getCoachType().equals(CoachType.ASSISTANT) && tmp.getCoaches().stream().filter(p -> p.getCoachType().equals(CoachType.ASSISTANT)).count() > 2)) {
                throw new TeamCoachesLimitException(coachDto.getTeamId());
            } else {
                Coach coach = coachRepository.save(new Coach(coachDto.getName(), coachDto.getCoachType(), tmp));
                tmp.getCoaches().add(coach);
                return Optional.of(coach);
            }
        } else
            throw new TeamDoesNotExistException(coachDto.getTeamId());
    }
    @Override
    public Optional<Coach> createForDataInitializer(String name, CoachType coachType, Long team) {
        if (teamRepository.findById(team).isPresent()) {
            Team tmp = teamRepository.findById(team).get();
            if ((coachType.equals(CoachType.HEAD) && tmp.getCoaches().stream().anyMatch(p -> p.getCoachType().equals(CoachType.HEAD)))
                    || (coachType.equals(CoachType.ASSISTANT) && tmp.getCoaches().stream().filter(p -> p.getCoachType().equals(CoachType.ASSISTANT)).count() > 2)) {
                throw new TeamCoachesLimitException(team);
            } else {
                Coach coach = coachRepository.save(new Coach(name, coachType, tmp));
                tmp.getCoaches().add(coach);
                return Optional.of(coach);
            }
        } else
            throw new TeamDoesNotExistException(team);
    }

    @Override
    public Optional<Coach> findById(Long id) {
        return Optional.of(coachRepository.findById(id).orElseThrow(() -> new CoachDoesNotExistException(id)));
    }

    @Override
    public Optional<Coach> delete(Long id) {
        Coach tmp = coachRepository.findById(id).orElseThrow(() -> new CoachDoesNotExistException(id));
        coachRepository.deleteById(id);
        return Optional.of(tmp);
    }


    //team e id so staticno se dava poso editiranjeto na objekt od coach e samo preku team
    @Override
    public Optional<Coach> edit(Long id, CoachDto coachDto) {
        Coach coach = coachRepository.findById(id).orElseThrow(() -> new CoachDoesNotExistException(id));
        coach.setName(coachDto.getName());
        if (teamRepository.findById(coachDto.getTeamId()).isPresent()) {
            Team tmp = teamRepository.findById(coachDto.getTeamId()).get();
            if ((coachDto.getCoachType().equals(CoachType.HEAD) && tmp.getCoaches().stream().anyMatch(p -> p.getCoachType().equals(CoachType.HEAD)))
                    || (coachDto.getCoachType().equals(CoachType.ASSISTANT) && tmp.getCoaches().stream().filter(p -> p.getCoachType().equals(CoachType.ASSISTANT)).count() > 2)) {
                throw new TeamCoachesLimitException(coachDto.getTeamId());
            } else {
                coach.setCoachType(coachDto.getCoachType());
            }
            tmp.getCoaches().remove(coach);
            tmp.getCoaches().add(coach);
            coachRepository.save(coach);
        } else
            throw new TeamDoesNotExistException(coachDto.getTeamId());
        return Optional.of(coach);
    }

    @Override
    public List<Coach> listAll() {
        return coachRepository.findAll();
    }

    @Override
    public boolean transfer(Long coachId, Long team1, Long team2) {
        Team teamFrom = teamRepository.findById(team1).orElseThrow(() -> new TeamDoesNotExistException(team1));
        Team teamTo = teamRepository.findById(team2).orElseThrow(() -> new TeamDoesNotExistException(team2));
        Coach coach = coachRepository.findById(coachId).orElseThrow(() -> new CoachDoesNotExistException(coachId));
        if ((coach.getCoachType().equals(CoachType.HEAD) && teamTo.getCoaches().stream().anyMatch(p -> p.getCoachType().equals(CoachType.HEAD)))
                || (coach.getCoachType().equals(CoachType.ASSISTANT) && teamTo.getCoaches().stream().filter(p -> p.getCoachType().equals(CoachType.ASSISTANT)).count() > 2)) {
            throw new TeamCoachesLimitException(team1);
        } else {
            teamFrom.getCoaches().remove(coach);
            teamTo.getCoaches().add(coach);
            coach.setTeam(teamTo);
            return true;
        }

    }
}
