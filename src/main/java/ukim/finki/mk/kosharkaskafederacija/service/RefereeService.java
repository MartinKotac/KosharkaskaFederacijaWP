package ukim.finki.mk.kosharkaskafederacija.service;

import ukim.finki.mk.kosharkaskafederacija.model.Referee;

import java.util.List;

public interface RefereeService {
    public Referee create(Integer level);
    public Referee delete(Long id);
    public Referee edit(Long id,Integer level);
    public Referee findById(Long id);
    public List<Referee> listAll();
}
