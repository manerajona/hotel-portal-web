package ar.edu.iua.portal.hotel.model.repository;

import ar.edu.iua.portal.hotel.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
}