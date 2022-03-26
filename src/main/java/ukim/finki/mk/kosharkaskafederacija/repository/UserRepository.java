package ukim.finki.mk.kosharkaskafederacija.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukim.finki.mk.kosharkaskafederacija.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUsernameAndPassword(String name, String password);
    Optional<User> findByUsername(String name);
}

