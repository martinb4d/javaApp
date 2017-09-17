package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    public Item findById(String id);
    public List<Item> findAll();
}
