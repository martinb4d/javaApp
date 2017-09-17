package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
    public User findByUsernameAndPassword(String username, String password);
    public List<User> findAll();
}
