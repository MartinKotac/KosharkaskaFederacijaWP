package ukim.finki.mk.kosharkaskafederacija.service;

import org.springframework.stereotype.Service;
import ukim.finki.mk.kosharkaskafederacija.enumerations.CoachType;
import ukim.finki.mk.kosharkaskafederacija.model.Coach;
import ukim.finki.mk.kosharkaskafederacija.model.Team;
import ukim.finki.mk.kosharkaskafederacija.model.dto.CoachDto;

import java.util.List;
import java.util.Optional;


public interface CoachService {
    public Optional<Coach> create(CoachDto coachDto);
    public Optional<Coach> createForDataInitializer(String name, CoachType coachType, Long team);
    public Optional<Coach> findById(Long id);
    public Optional<Coach> delete(Long id);
    public Optional<Coach> edit(Long id,CoachDto coachDto);
    public List<Coach> listAll();
    public boolean transfer(Long coachId,Long team1,Long team2);
}
