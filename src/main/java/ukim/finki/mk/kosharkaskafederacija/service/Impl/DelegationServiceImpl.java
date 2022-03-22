package ukim.finki.mk.kosharkaskafederacija.service.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.kosharkaskafederacija.exceptions.RefereeDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.model.Delegation;
import ukim.finki.mk.kosharkaskafederacija.model.Referee;
import ukim.finki.mk.kosharkaskafederacija.repository.DelegationRepository;
import ukim.finki.mk.kosharkaskafederacija.service.DelegationService;

import java.util.List;

@Service
public class DelegationServiceImpl implements DelegationService {
    private final DelegationRepository delegationRepository;

    public DelegationServiceImpl(DelegationRepository delegationRepository) {
        this.delegationRepository = delegationRepository;
    }

    @Override
    public Delegation create(Integer level) {
        return delegationRepository.save(new Delegation(level));
    }

    @Override
    public Delegation delete(Long id) {
        Delegation delegation=delegationRepository.findById(id).orElseThrow(()->new RefereeDoesNotExistException(id));
        delegationRepository.delete(delegation);
        return delegation;
    }

    @Override
    public Delegation edit(Long id, Integer level) {
        Delegation delegation=delegationRepository.findById(id).orElseThrow(()->new RefereeDoesNotExistException(id));
        delegation.setLevel(level);
        return delegation;
    }

    @Override
    public Delegation findById(Long id) {
        return delegationRepository.findById(id).orElseThrow(()->new RefereeDoesNotExistException(id));
    }

    @Override
    public List<Delegation> listAll() {
        return delegationRepository.findAll();
    }
}
