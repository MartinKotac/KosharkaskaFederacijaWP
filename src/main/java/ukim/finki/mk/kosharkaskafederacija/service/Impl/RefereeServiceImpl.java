package ukim.finki.mk.kosharkaskafederacija.service.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.kosharkaskafederacija.exceptions.RefereeDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.model.Referee;
import ukim.finki.mk.kosharkaskafederacija.model.dto.RefereeDto;
import ukim.finki.mk.kosharkaskafederacija.repository.RefereeRepository;
import ukim.finki.mk.kosharkaskafederacija.service.RefereeService;

import java.util.List;
import java.util.Optional;

@Service
public class RefereeServiceImpl implements RefereeService {

    private final RefereeRepository refereeRepository;

    public RefereeServiceImpl(RefereeRepository refereeRepository) {
        this.refereeRepository = refereeRepository;
    }

    @Override
    public Optional<Referee> create(RefereeDto refereeDto) {
       Referee referee=new Referee(refereeDto.getLevel());
       return Optional.of(refereeRepository.save(referee));
    }

    @Override
    public Optional<Referee> delete(Long id) {
        Referee referee=refereeRepository.findById(id).orElseThrow(()->new RefereeDoesNotExistException(id));
        refereeRepository.delete(referee);
        return Optional.of(referee);
    }

    @Override
    public Optional<Referee> edit(Long id, RefereeDto refereeDto) {
        Referee referee=refereeRepository.findById(id).orElseThrow(()->new RefereeDoesNotExistException(id));
        referee.setLevel(refereeDto.getLevel());
        return Optional.of(referee);
    }

    @Override
    public Optional<Referee> findById(Long id) {
        return Optional.of(refereeRepository.findById(id).orElseThrow(()->new RefereeDoesNotExistException(id)));
    }

    @Override
    public List<Referee> listAll() {
        return refereeRepository.findAll();
    }
}
