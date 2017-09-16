package application.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	public long id;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getId() {
		return id;
	}

	@JsonIgnore
	public String password;
	public String username;
	public Timestamp createdDate;
	
	@ManyToOne
    private UserRole role;
	
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public User(String username, String password, UserRole role){
		this.username=username;
		this.password=password;
		this.role = role;
		this.createdDate=new Timestamp(System.currentTimeMillis());
	}
	
	public User(String username, String password, UserRole role, Timestamp createdDate){
		this.username=username;
		this.password=password;
		this.role = role;
		this.createdDate=createdDate;
	}
	
	User(){
	}

}
