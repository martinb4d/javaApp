package application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.exceptions.BusinessException;
import application.model.Purchase;
import application.model.User;
import application.repository.PurchaseRepository;
import application.repository.UserRepository;
import application.service.PurchaseService;
import application.service.UserService;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	private PurchaseRepository purchaseRepository;

	public Purchase getItemById(String id) {
		return purchaseRepository.findById(id);
	}

	public List<Purchase> getAllItem() {
		return purchaseRepository.findAll();
	}
	
	public void save(Purchase purchase){
		purchaseRepository.save(purchase);
	}
	
}
