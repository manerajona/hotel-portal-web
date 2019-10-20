package ar.edu.iua.portal.hotel.repository;

import ar.edu.iua.portal.hotel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1 and u.password = ?2")
    User findByUserAndPassword(String username, String password);

    Optional<User> findByUsername(String username);

    User findByEmail(String email);
}
