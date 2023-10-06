package com.cg.bim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bim.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
List<Inventory> findInventoryByInventoryID(Integer inventoryId);
List<Inventory> findInventoryByIsbn(String isbn);
List<Inventory> findInventoryByRanks(Integer ranks);
List<Inventory> findInventoryByPurchased(byte purchased);
}
