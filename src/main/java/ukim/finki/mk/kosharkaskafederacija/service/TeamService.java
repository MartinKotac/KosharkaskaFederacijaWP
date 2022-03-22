package ukim.finki.mk.kosharkaskafederacija.service;

import ukim.finki.mk.kosharkaskafederacija.model.Team;

public interface TeamService {
    public Team create(String name,String address,String sponsor,String homeField);
    public Team findById(Long id);
    public Team delete(Long id);

}
