package com.cg.bim.controller;




import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bim.entity.PurchaseLog;

import com.cg.bim.repository.PurchaseLogRepository;
@RestController
@RequestMapping("/api")
public class PurchaseLogController {
    @Autowired
    private PurchaseLogRepository purchaseLogRepository;
    @PostMapping("/purchaselog/post")
    public ResponseEntity<PurchaseLog> createPurchaseLog(@RequestBody PurchaseLog purchaseLog) throws Exception{
        if(purchaseLog==null) {
            throw new Exception("You forgot to write Body!!!");
        }else {
            purchaseLogRepository.save(purchaseLog);
            return new ResponseEntity<PurchaseLog>(purchaseLog, HttpStatus.OK);
        }
    }
    @GetMapping("/purchaselogs")
    public ResponseEntity<List<PurchaseLog>> getPurchaseLogs(){
        List<PurchaseLog> purchaseLogs= purchaseLogRepository.findAll();
        if(purchaseLogs==null) {
            return new ResponseEntity<List<PurchaseLog>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<PurchaseLog>>(purchaseLogs,HttpStatus.OK);
    }
    
    
    @PutMapping("/purchaselog/update/inventoryid/{userid}")
    public ResponseEntity<PurchaseLog> modifyPurchaseLogFirstName(@PathVariable("userid") Integer userid, @RequestBody Integer inventoryid) throws Exception{
    	List<PurchaseLog> purchaseLog1=purchaseLogRepository.findPurchaseLogByUserID(userid);
        if(purchaseLog1.get(0)==null) {
            throw new Exception("Idiot Request Id Not Found");
        }else{
            purchaseLog1.get(0).setInventoryID(inventoryid);
            purchaseLogRepository.save(purchaseLog1.get(0));
            return new ResponseEntity<PurchaseLog>(purchaseLog1.get(0), HttpStatus.OK);
         }
   }
    
    @GetMapping("/purchaseLog/{userid}")
    public ResponseEntity<List<PurchaseLog>> getAllPurchaseLogsBy(@PathVariable("userid") Integer userid) throws Exception{
        List<PurchaseLog> purchaseLog=purchaseLogRepository.findPurchaseLogByUserID(userid);
        if(purchaseLog.get(0)==null) {
            throw new Exception("Idiot Id not Found!!!");
        }else {
            //purchaseLogRepository.deleteById(purchaseLogid);
            return new ResponseEntity<List<PurchaseLog>>(purchaseLog,HttpStatus.OK);
        }
    }
}