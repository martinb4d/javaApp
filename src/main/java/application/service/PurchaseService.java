package application.service;

import java.util.List;

import application.model.Purchase;

public interface PurchaseService {
	public Purchase getItemById(String id);
	public List<Purchase> getAllItem();
	public void save(Purchase purchase);
}
