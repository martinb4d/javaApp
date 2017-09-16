package application;

import java.sql.Timestamp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import application.model.User;
import application.model.UserRole;
import application.repository.UserRepository;
import application.repository.UserRoleRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository,
			UserRoleRepository userRoleRepository) {
		UserRole employee = userRoleRepository.save(new UserRole("employee", "employee"));
		UserRole affiliate = userRoleRepository.save(new UserRole("affiliate", "affiliate"));
		UserRole customer = userRoleRepository.save(new UserRole("customer", "customer"));
		userRepository.save(new User("employee1", "password", employee));
		userRepository.save(new User("affiliate1", "password", affiliate));
		userRepository.save(new User("customer1", "password", customer));
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		timestamp.setYear(2010);
		userRepository.save(new User("customer2", "password", customer, timestamp));
		return null;
	}
}