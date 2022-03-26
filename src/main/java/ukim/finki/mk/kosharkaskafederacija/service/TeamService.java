package ukim.finki.mk.kosharkaskafederacija.service;

import ukim.finki.mk.kosharkaskafederacija.model.Team;

import java.util.List;

public interface TeamService {
    public Team create(String name,String address,String sponsor,String homeField);
    public Team findById(Long id);
    public Team delete(Long id);
    public Team edit(Long id,String name,String address,String sponsor,String homeField);
    public void increasePoints(Long id,Integer points);
    public List<Team> listAll();
}
