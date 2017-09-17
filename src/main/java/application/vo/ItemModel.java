package application.vo;

import java.math.BigDecimal;


public class ItemModel {
	public String id;
	public String name;
	public String category;
	public BigDecimal price;
	public Integer qty;
	public BigDecimal ttlPrice;
	
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


	public Integer getQty() {
		return qty;
	}


	public void setQty(Integer qty) {
		this.qty = qty;
	}


	public BigDecimal getTtlPrice() {
		return ttlPrice;
	}

	public void setTtlPrice(BigDecimal ttlPrice) {
		this.ttlPrice = ttlPrice;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
	
	

}