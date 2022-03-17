package ukim.finki.mk.kosharkaskafederacija.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukim.finki.mk.kosharkaskafederacija.model.Referee;

@Repository
public interface RefereeRepository extends JpaRepository<Referee,Integer> {
}
