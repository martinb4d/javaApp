package application.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Item;
import application.repository.ItemRepository;
import application.service.ItemService;
import application.vo.ItemModel;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemRepository itemRepository;

	public Item getItemById(String id) {
		return itemRepository.findById(id);
	}
	
	public List<Item> getAllItem() {
		return itemRepository.findAll();
	}
	
	public List<ItemModel> getAllItemModel() {
		List<Item> itemList = itemRepository.findAll();
		List itemModelList = new ArrayList();
		for(Item item : itemList){
			ItemModel itemModel = new ItemModel();
			itemModel.setId(item.getId());
			itemModel.setName(item.getName());
			itemModel.setPrice(item.getPrice());
			itemModel.setCategory(item.getCategory());
			itemModelList.add(itemModel);
		}
		return itemModelList;
	}
	
}
