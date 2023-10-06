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

import com.cg.bim.entity.Inventory;
import com.cg.bim.repository.InventoryRepository;
@RestController
@RequestMapping("/api")
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepository;
    @PostMapping("/inventory/post")
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) throws Exception{
        if(inventory==null) {
            throw new Exception("You forgot to write body!!");
        }else {
            inventoryRepository.save(inventory);
            return new ResponseEntity<Inventory>(inventory, HttpStatus.OK);
        }
    }
    @GetMapping("/inventorys")
    public ResponseEntity<List<Inventory>> getInventorys(){
        List<Inventory> inventorys= inventoryRepository.findAll();
        if(inventorys==null) {
            return new ResponseEntity<List<Inventory>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Inventory>>(inventorys,HttpStatus.OK);
    }
    
    
    @PutMapping("/bookinventory/update/purchased/{inventoryId}")
    public ResponseEntity<Inventory> modifyInventoryFirstName(@PathVariable("inventoryId") Integer inventoryId, @RequestBody byte purchased) throws Exception{
    	List<Inventory> inventory1=inventoryRepository.findInventoryByInventoryID(inventoryId);
        if(inventory1.get(0)==null) {
            throw new Exception("Idiot Request Id Not Found");
        }else{
            inventory1.get(0).setPurchased(purchased);
            inventoryRepository.save(inventory1.get(0));
            return new ResponseEntity<Inventory>(inventory1.get(0), HttpStatus.OK);
         }
   }
    
    @GetMapping("/inventory/{inventoryid}")
    public ResponseEntity<List<Inventory>> getAllInventorysBy(@PathVariable("inventoryid") Integer inventoryid) throws Exception{
        List<Inventory> inventory=inventoryRepository.findInventoryByInventoryID(inventoryid);
        if(inventory.get(0)==null) {
            throw new Exception("Idiot Id not Found!!!");
        }else {
            //inventoryRepository.deleteById(inventoryid);
            return new ResponseEntity<List<Inventory>>(inventory,HttpStatus.OK);
        }
    }
}