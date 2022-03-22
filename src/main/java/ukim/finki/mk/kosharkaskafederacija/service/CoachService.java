package ukim.finki.mk.kosharkaskafederacija.service;

import org.springframework.stereotype.Service;
import ukim.finki.mk.kosharkaskafederacija.enumerations.CoachType;
import ukim.finki.mk.kosharkaskafederacija.model.Coach;
import ukim.finki.mk.kosharkaskafederacija.model.Team;

import java.util.List;


public interface CoachService {
    public Coach create(String name, CoachType coachType, Long team);
    public Coach findById(Long id);
    public Coach delete(Long id,Long teamId);
    public Coach edit(Long id,String name, CoachType coachType,Long team);
    public List<Coach> listAll();
    public boolean transfer(Long coachId,Long team1,Long team2);
}
