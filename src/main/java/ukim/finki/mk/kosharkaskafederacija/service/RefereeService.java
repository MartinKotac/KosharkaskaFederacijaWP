package ukim.finki.mk.kosharkaskafederacija.service;

import ukim.finki.mk.kosharkaskafederacija.model.Referee;
import ukim.finki.mk.kosharkaskafederacija.model.dto.RefereeDto;

import java.util.List;
import java.util.Optional;

public interface RefereeService {
    public Optional<Referee> create(RefereeDto refereeDto);
    public Optional<Referee> delete(Long id);
    public Optional<Referee> edit(Long id,RefereeDto refereeDto);
    public Optional<Referee> findById(Long id);
    public List<Referee> listAll();
}
