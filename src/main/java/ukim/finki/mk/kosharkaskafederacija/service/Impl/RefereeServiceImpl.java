package ukim.finki.mk.kosharkaskafederacija.service.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.kosharkaskafederacija.exceptions.RefereeDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.model.Referee;
import ukim.finki.mk.kosharkaskafederacija.repository.RefereeRepository;
import ukim.finki.mk.kosharkaskafederacija.service.RefereeService;

import java.util.List;

@Service
public class RefereeServiceImpl implements RefereeService {

    private final RefereeRepository refereeRepository;

    public RefereeServiceImpl(RefereeRepository refereeRepository) {
        this.refereeRepository = refereeRepository;
    }

    @Override
    public Referee create(Integer level) {
        return refereeRepository.save(new Referee(level));
    }

    @Override
    public Referee delete(Long id) {
        Referee referee=refereeRepository.findById(id).orElseThrow(()->new RefereeDoesNotExistException(id));
        refereeRepository.delete(referee);
        return referee;
    }

    @Override
    public Referee edit(Long id, Integer level) {
        Referee referee=refereeRepository.findById(id).orElseThrow(()->new RefereeDoesNotExistException(id));
        referee.setLevel(level);
        return referee;
    }

    @Override
    public Referee findById(Long id) {
        return refereeRepository.findById(id).orElseThrow(()->new RefereeDoesNotExistException(id));
    }

    @Override
    public List<Referee> listAll() {
        return refereeRepository.findAll();
    }
}
