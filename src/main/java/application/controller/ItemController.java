package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Item;
import application.vo.ItemModel;
import application.service.ItemService;

@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/getItemList")
	public List<ItemModel> getItem(){
		return itemService.getAllItemModel();
	}
}
