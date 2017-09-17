package application.service;

import java.util.List;

import application.model.Item;
import application.vo.ItemModel;

public interface ItemService {
	public Item getItemById(String id);
	public List<Item> getAllItem();
	public List<ItemModel> getAllItemModel();
}
