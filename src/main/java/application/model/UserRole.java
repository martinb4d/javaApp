package application.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserRole {
	
	@Id
	public String id;
	public String description;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserRole(String id, String description){
		this.id=id;
		this.description=description;
	}
	
	UserRole(){
		
	}
	
}
