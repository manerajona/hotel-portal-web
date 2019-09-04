package ar.edu.iua.portal.hotel.repository;

import ar.edu.iua.portal.hotel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT iduser, username, password, email, first_name, last_name, is_admin FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
    Optional<User> findByUserAndPassword(String user, String pass);
}
