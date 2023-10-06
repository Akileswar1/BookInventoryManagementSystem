package com.cg.bim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bim.entity.PurchaseLog;
import com.cg.bim.entity.PurchaseLogPrimaries;
@Repository
public interface PurchaseLogRepository extends JpaRepository<PurchaseLog, PurchaseLogPrimaries>{
	List<PurchaseLog> findPurchaseLogByUserID(Integer userID);
	List<PurchaseLog> findPurchaseLogByInventoryID(Integer inventoryID);
}
