package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    public Purchase findById(String id);
    public List<Purchase> findAll();
}
