package ukim.finki.mk.kosharkaskafederacija.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukim.finki.mk.kosharkaskafederacija.model.Game;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
    List<Game> findAllByDateОfMaintenance(LocalDate date);
}
