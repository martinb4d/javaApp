package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Purchase;
import application.service.PurchaseService;

@RestController
public class PurchaseController {
	@Autowired
	private PurchaseService purchaseService;
	
	@RequestMapping("/getPurchase")
	public List<Purchase> getItem(){
		return purchaseService.getAllItem();
	}
}
