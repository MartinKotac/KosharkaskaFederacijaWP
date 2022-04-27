package ukim.finki.mk.kosharkaskafederacija.service;

import ukim.finki.mk.kosharkaskafederacija.model.Player;
import ukim.finki.mk.kosharkaskafederacija.model.Team;
import ukim.finki.mk.kosharkaskafederacija.model.dto.PlayerDto;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    public Optional<Player> create(PlayerDto playerDto);
    public Optional<Player> delete(Long id);
    public Optional<Player> edit(Long id, PlayerDto playerDto);
    public boolean transfer(Long from,Long to,Long playerId);
    public Optional<Player> findById(Long id);
    public List<Player> listAll();
    public void setPpg();
    public void setAng();
    public void setRpg();
    public void setMpg();
    public void addGame();

}
