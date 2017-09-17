package application.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	@JsonIgnore
	public String password;
	public String username;
	public String name;
	public Timestamp createdDate;
	public String createdDateFormatted;
	
	@ManyToOne
    private UserRole role;
	
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
	public String getCreatedDateFormatted(){
		return new SimpleDateFormat("dd-MM-yyyy").format(this.createdDate);
	}

	public User(String username, String password, UserRole role, String name){
		this.username=username;
		this.password=password;
		this.role = role;
		this.name=name;
		this.createdDate=new Timestamp(System.currentTimeMillis());
	}
	
	public User(String username, String password, UserRole role, String name, Timestamp createdDate){
		this.username=username;
		this.password=password;
		this.role = role;
		this.name=name;
		this.createdDate=createdDate;
	}
	
	User(){
		
	}
}
