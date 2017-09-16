package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
