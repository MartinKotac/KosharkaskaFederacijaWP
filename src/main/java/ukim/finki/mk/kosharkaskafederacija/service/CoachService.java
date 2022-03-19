package ukim.finki.mk.kosharkaskafederacija.service;

import org.springframework.stereotype.Service;
import ukim.finki.mk.kosharkaskafederacija.enumerations.CoachType;
import ukim.finki.mk.kosharkaskafederacija.model.Coach;
import ukim.finki.mk.kosharkaskafederacija.model.Team;

import java.util.List;


public interface CoachService {
    public Coach create(String name, CoachType coachType, String team);
    public Coach findById(Long id);
    public Coach delete(Long id);
    public Coach deleteFromTeam(Long coachId,String teamName);
    public Coach edit(Long id,String name, CoachType coachType,String team);
    public List<Coach> listAll();

}
