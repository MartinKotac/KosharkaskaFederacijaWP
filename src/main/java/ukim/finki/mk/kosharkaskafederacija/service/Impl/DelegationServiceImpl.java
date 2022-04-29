package ukim.finki.mk.kosharkaskafederacija.service.Impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.kosharkaskafederacija.exceptions.RefereeDoesNotExistException;
import ukim.finki.mk.kosharkaskafederacija.model.Delegation;
import ukim.finki.mk.kosharkaskafederacija.model.Referee;
import ukim.finki.mk.kosharkaskafederacija.model.dto.DelegationDto;
import ukim.finki.mk.kosharkaskafederacija.repository.DelegationRepository;
import ukim.finki.mk.kosharkaskafederacija.service.DelegationService;

import java.util.List;
import java.util.Optional;

@Service
public class DelegationServiceImpl implements DelegationService {
    private final DelegationRepository delegationRepository;

    public DelegationServiceImpl(DelegationRepository delegationRepository) {
        this.delegationRepository = delegationRepository;
    }

    @Override
    public Optional<Delegation> create(Integer level) {
        Delegation delegation=new Delegation(level);
        return Optional.of(delegationRepository.save(delegation));

    }

    @Override
    public Optional<Delegation> delete(Long id) {
        Delegation delegation=delegationRepository.findById(id).orElseThrow(()->new RefereeDoesNotExistException(id));
        delegationRepository.delete(delegation);
        return Optional.of(delegation);
    }

    @Override
    public Optional<Delegation> edit(Long id, DelegationDto delegationDto) {
        Delegation delegation=delegationRepository.findById(id).orElseThrow(()->new RefereeDoesNotExistException(id));
        delegation.setLevel(delegationDto.getLevel());
        return Optional.of(delegation);
    }

    @Override
    public Optional<Delegation> findById(Long id) {
        return Optional.of(delegationRepository.findById(id).orElseThrow(()->new RefereeDoesNotExistException(id)));
    }

    @Override
    public List<Delegation> listAll() {
        return delegationRepository.findAll();
    }
}
