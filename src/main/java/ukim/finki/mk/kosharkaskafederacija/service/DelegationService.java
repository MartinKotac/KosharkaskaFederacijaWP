package ukim.finki.mk.kosharkaskafederacija.service;

import ukim.finki.mk.kosharkaskafederacija.model.Delegation;
import ukim.finki.mk.kosharkaskafederacija.model.Referee;
import ukim.finki.mk.kosharkaskafederacija.model.dto.DelegationDto;

import java.util.List;
import java.util.Optional;

public interface DelegationService {
    public Optional<Delegation> create(DelegationDto delegationDto);
    public Optional<Delegation> delete(Long id);
    public Optional<Delegation> edit(Long id, DelegationDto delegationDto);
    public Optional<Delegation> findById(Long id);
    public List<Delegation> listAll();
}
