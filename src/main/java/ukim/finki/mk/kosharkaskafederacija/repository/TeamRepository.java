package ukim.finki.mk.kosharkaskafederacija.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukim.finki.mk.kosharkaskafederacija.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team,String> {
}
