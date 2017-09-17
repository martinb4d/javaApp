package application;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import application.model.Item;
import application.model.User;
import application.model.UserRole;
import application.repository.ItemRepository;
import application.repository.UserRepository;
import application.repository.UserRoleRepository;

@SpringBootApplication
public class Application {
	
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository, UserRoleRepository userRoleRepository, ItemRepository itemRepository) {
		UserRole employee = userRoleRepository.save(new UserRole("employee", "employee", 18));
		UserRole affiliate = userRoleRepository.save(new UserRole("affiliate", "affiliate", 15));
		UserRole customer = userRoleRepository.save(new UserRole("customer", "customer", 10));
		userRepository.save(new User("employee1", "password", employee, "Will"));
		userRepository.save(new User("affiliate1", "password", affiliate, "Alex"));
		userRepository.save(new User("customer1", "password", customer, "Smith"));
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		timestamp.setYear(timestamp.getYear()-2);
		timestamp.setMonth(timestamp.getMonth()-1);
		userRepository.save(new User("customer2", "password", customer, "John", timestamp));
		itemRepository.save(new Item("item1", "Cell Phone", new BigDecimal("1000"),"accessories"));
		itemRepository.save(new Item("item2", "Hat", new BigDecimal("250"),"accessories"));
		itemRepository.save(new Item("item3", "Earring", new BigDecimal("500"),"accessories"));
		itemRepository.save(new Item("item4", "Vegetables", new BigDecimal("200"),"groceries"));
		itemRepository.save(new Item("item5", "Fruit", new BigDecimal("50"),"groceries"));
		itemRepository.save(new Item("item6", "Rice", new BigDecimal("300"),"groceries"));
		itemRepository.save(new Item("item7", "Candy", new BigDecimal("20"),"snacks"));
		itemRepository.save(new Item("item8", "Cheetos", new BigDecimal("25"),"snacks"));
		return null;
	}
}