package application.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	public String id;
	public String name;
	public String category;
	public BigDecimal price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	} 
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Item(String id, String name, BigDecimal price, String category){
		this.id=id;
		this.name=name;
		this.price=price;
		this.category=category;
	}
	

	public Item(){
		
	}
}
