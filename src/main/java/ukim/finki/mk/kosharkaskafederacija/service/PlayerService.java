package ukim.finki.mk.kosharkaskafederacija.service;

import ukim.finki.mk.kosharkaskafederacija.model.Player;
import ukim.finki.mk.kosharkaskafederacija.model.Team;

import java.util.List;

public interface PlayerService {
    public Player create(String name, Integer jerseyNumber, String position, Long teamId);
    public Player delete(Long id);
    public Player edit(Long id,String name,Integer jerseyNumber, String position, String teamName);
    public Player findById(Long id);
    public List<Player> listAll();
    public void setPpg();
    public void setAng();
    public void setRpg();
    public void setMpg();
    public void addGame();

}
