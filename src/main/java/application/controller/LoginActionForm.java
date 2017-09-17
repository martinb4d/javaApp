package application.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import application.model.Item;
import application.model.Purchase;

public class LoginActionForm {
	private String username;
	private String password;
	private String message;
	private String name;
	private String screenState;
	private int quantity[];
	private float discount;
	private List<Item> itemList;
	private BigDecimal amount[];
	private BigDecimal total;
	private List<Purchase> purchaseList;
	private Timestamp registeredDate;
	private String itemSelected[];
	
	public Timestamp getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Timestamp registeredDate) {
		this.registeredDate = registeredDate;
	}
	public List<Purchase> getPurchaseList() {
		return purchaseList;
	}
	public void setPurchaseList(List<Purchase> purchaseList) {
		this.purchaseList = purchaseList;
	}
	public BigDecimal[] getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal[] amount) {
		this.amount = amount;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getScreenState() {
		return screenState;
	}
	public void setScreenState(String screenState) {
		this.screenState = screenState;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public int[] getQuantity() {
		return quantity;
	}
	public void setQuantity(int[] quantity) {
		this.quantity = quantity;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String[] getItemSelected() {
		return itemSelected;
	}
	public void setItemSelected(String[] itemSelected) {
		this.itemSelected = itemSelected;
	}
	
}
