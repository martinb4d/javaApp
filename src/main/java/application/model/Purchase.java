package application.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Purchase {
	
	@Id
	@GeneratedValue
	public long id;
	
	private Timestamp createdDate;
	@ManyToOne
	private User user;
	@ManyToOne
	private Item item;
	private int quantity;
	private BigDecimal amount;
	
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public long getId() {
		return id;
	}
	
	public Purchase(User user, Item item, int quantity, BigDecimal amount, Timestamp createdDate){
		this.setUser(user);
		this.setItem(item);
		this.setQuantity(quantity);
		this.setAmount(amount);
		this.setCreatedDate(createdDate);
	}
	
	public Purchase() {
	}
}
