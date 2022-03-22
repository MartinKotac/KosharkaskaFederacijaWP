package ukim.finki.mk.kosharkaskafederacija.service;

import ukim.finki.mk.kosharkaskafederacija.model.Delegation;
import ukim.finki.mk.kosharkaskafederacija.model.Referee;

import java.util.List;

public interface DelegationService {
    public Delegation create(Integer level);
    public Delegation delete(Long id);
    public Delegation edit(Long id,Integer level);
    public Delegation findById(Long id);
    public List<Delegation> listAll();
}
